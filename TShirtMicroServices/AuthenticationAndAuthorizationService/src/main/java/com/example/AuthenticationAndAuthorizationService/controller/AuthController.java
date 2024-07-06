package com.example.AuthenticationAndAuthorizationService.controller;

import com.example.AuthenticationAndAuthorizationService.dto.RequestResponse;
import com.example.AuthenticationAndAuthorizationService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<RequestResponse> signUp(@RequestBody RequestResponse reqres){
        return ResponseEntity.ok(authService.SignUp(reqres));
    }

    @PostMapping("/signin")
    public  ResponseEntity<RequestResponse> signIn(@RequestBody RequestResponse reqres){
        return ResponseEntity.ok(authService.SignIn(reqres));
    }

}
