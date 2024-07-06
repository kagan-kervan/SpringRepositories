package com.example.AuthenticationAndAuthorizationService.dto;

import com.example.AuthenticationAndAuthorizationService.entity.ServiceUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RequestResponse {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationDate;
    private String name;
    private String email;
    private String role;
    private String password;
    private ServiceUser ourUsers;
}
