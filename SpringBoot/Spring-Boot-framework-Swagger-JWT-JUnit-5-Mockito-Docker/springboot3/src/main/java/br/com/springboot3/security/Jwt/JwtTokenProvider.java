package br.com.springboot3.security.Jwt;

import br.com.springboot3.data.vo.v1.security.TokenVO;
import br.com.springboot3.exception.InvalidJwtAuthenticationException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Temporal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtTokenProvider {
    @Value("${security.token.secret-key:secret}")
    private String secretKey = "secret";

    @Value("${security.token.expire-length:1}")
    private long validiTyMilliseconds = 1; //1h

    @Autowired
    private UserDetailsService userDetailsService;

    Algorithm algorithm = null;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        algorithm = Algorithm.HMAC256(secretKey.getBytes());
    }

    public TokenVO createAccessToken(String username, List<String> roles) {
        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime expire = now.plusMinutes(validiTyMilliseconds);
        LocalDateTime expire = now.plusHours(validiTyMilliseconds);
        String accessToken = getAccessToken(username, roles, now, expire);
        String refreshToken = getRefreshToken(username, roles, now);
        return new TokenVO(username, true, now, expire, accessToken, refreshToken,"RENAN SEREIA");
    }


    public TokenVO refreshToken(String refreshToken) {
        if (refreshToken.contains("Bearer ")) refreshToken = refreshToken.substring("Bearer ".length());

        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodeJwt = verifier.verify(refreshToken);
        String username = decodeJwt.getSubject();
        return createAccessToken(username,decodeJwt.getClaim("roles").asList(String.class));

    }
    private String getRefreshToken(String username, List<String> roles, LocalDateTime now) {
        LocalDateTime expireRefresh = LocalDateTime.now().plusHours(validiTyMilliseconds * 3);
        return JWT.create()
                .withClaim("roles", roles)
                .withIssuedAt(new Date(now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
                .withExpiresAt(new Date(expireRefresh.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
                .withSubject(username)
                .sign(algorithm)
                .strip();
    }

    private String getAccessToken(String username, List<String> roles, LocalDateTime now, LocalDateTime expire) {
        String uriString = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return JWT.create()
                .withClaim("roles", roles)
                .withIssuedAt(new Date(now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
                .withExpiresAt(new Date(expire.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
                .withSubject(username)
                .withIssuer(uriString)
                .sign(algorithm)
                .strip();
    }

    public Authentication getAuthentication(String token) {
        DecodedJWT decodedJWT = decodeToken(token);
        UserDetails userDetails = this.userDetailsService.
                loadUserByUsername(decodedJWT.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails
                , "", userDetails.getAuthorities());
    }

    private DecodedJWT decodeToken(String token) {
        Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
        JWTVerifier verifier = JWT.require(alg).build();
        return verifier.verify(token);
    }

    public String resolveToken(HttpServletRequest servletRequest) {
        String authorization = servletRequest.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            return authorization.substring("Bearer ".length());
        }
        return null;

    }

    public boolean validateToken(String token)  {
        try {
            DecodedJWT decodedJWT = decodeToken(token);
            if (decodedJWT.getExpiresAt().before(new Date())) {
                return false;
            }
            return true;
        } catch (Exception e) {
            try {
                throw new InvalidJwtAuthenticationException("Expired or Invalid JWT Token!");
            } catch (InvalidJwtAuthenticationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
