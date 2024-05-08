package br.com.springboot3.services;

import br.com.springboot3.data.vo.v1.security.AccountCredentialsVO;
import br.com.springboot3.data.vo.v1.security.TokenVO;
import br.com.springboot3.model.User;
import br.com.springboot3.repositories.UserRepositorie;
import br.com.springboot3.security.Jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepositorie userRepositorie;

    public ResponseEntity<TokenVO> signin(AccountCredentialsVO userNamePassword){
        try {
            var username = userNamePassword.getUsername();
            var password = userNamePassword.getPassword();

//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

            User user = userRepositorie.findByUserName(username);

            TokenVO tokenResponse ;

            if (user != null){
                tokenResponse = jwtTokenProvider.createAccessToken(username,user.getRoles());
            }else {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }
            return ResponseEntity.ok(tokenResponse);
        }catch (Exception e){
            e.printStackTrace();
            throw new BadCredentialsException("Inavalid username/password supplied!");
        }
    }

    public ResponseEntity<TokenVO> refreshToken(String username, String refreshToken){
            User user = userRepositorie.findByUserName(username);

            TokenVO tokenResponse ;

            if (user != null){
                tokenResponse = jwtTokenProvider.refreshToken(refreshToken);
            }else {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }
            return ResponseEntity.ok(tokenResponse);
    }

}
