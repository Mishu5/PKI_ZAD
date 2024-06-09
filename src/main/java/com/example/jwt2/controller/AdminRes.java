package com.example.jwt2.controller;

import com.example.jwt2.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("resource/admin")
public class AdminRes {

    @GetMapping
    public ResponseEntity<String> getResources(@RequestHeader("Authorization") String jwt){
        jwt = Token.extractToken(jwt);
        if(Token.JwtValidation(jwt).equals("ADMIN")){
            return ResponseEntity.status(HttpStatus.OK).body("Granted");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }
}