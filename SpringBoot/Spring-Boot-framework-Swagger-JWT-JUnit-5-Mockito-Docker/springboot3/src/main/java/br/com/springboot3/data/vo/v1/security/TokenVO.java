package br.com.springboot3.data.vo.v1.security;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class TokenVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 6768922243360139186L;

    private String username;
    private Boolean authentication;
    private LocalDateTime created;
    private LocalDateTime expiration;
    private String accessToken;
    private String refreshToken;
    private String nameTest = "";

    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    public TokenVO() {
    }
    public TokenVO(String username,
                   Boolean authentication,
                   LocalDateTime created,
                   LocalDateTime expiration,
                   String accesToken,
                   String refreshToken,String nameTest) {
        this.username = username;
        this.authentication = authentication;
        this.created = created;
        this.expiration = expiration;
        this.accessToken = accesToken;
        this.refreshToken = refreshToken;
        this.nameTest = nameTest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Boolean authentication) {
        this.authentication = authentication;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenVO tokenVO = (TokenVO) o;
        return Objects.equals(username, tokenVO.username) && Objects.equals(authentication, tokenVO.authentication) && Objects.equals(created, tokenVO.created) && Objects.equals(expiration, tokenVO.expiration) && Objects.equals(accessToken, tokenVO.accessToken) && Objects.equals(refreshToken, tokenVO.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, authentication, created, expiration, accessToken, refreshToken);
    }
}
