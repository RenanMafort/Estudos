package br.com.springboot3.controller;

import br.com.springboot3.data.vo.v1.security.AccountCredentialsVO;
import br.com.springboot3.data.vo.v1.security.TokenVO;
import br.com.springboot3.services.AuthServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication EndPoint")
public class AuthController {

    @Autowired
    AuthServices authServices;

    @Operation(summary = "Authenticates a user and returns a token!")
    @PostMapping("/signin")
    public  ResponseEntity<?> sigin(@RequestBody AccountCredentialsVO data){
        if (data == null || data.getUsername() == null || data.getUsername().isBlank()
        ||data.getPassword() == null || data.getPassword().isBlank())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        ResponseEntity<TokenVO> token = authServices.signin(data);

        if (token == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        return token;
    }

    @Operation(summary = "Refresh a token!")
    @PutMapping("/refresh/{username}")
    public  ResponseEntity<?> refreshToken(@PathVariable("username") String username,
    @RequestHeader("Authorization") String refreshToken){
        if (username == null || username.isBlank() ||
                refreshToken == null || refreshToken.isBlank())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        var token = authServices.refreshToken(username, refreshToken);

        if (token == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        return token;
    }
}
