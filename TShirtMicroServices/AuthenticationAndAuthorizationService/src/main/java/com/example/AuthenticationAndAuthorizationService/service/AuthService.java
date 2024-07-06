package com.example.AuthenticationAndAuthorizationService.service;

import com.example.AuthenticationAndAuthorizationService.dto.RequestResponse;
import com.example.AuthenticationAndAuthorizationService.entity.ServiceUser;
import com.example.AuthenticationAndAuthorizationService.repository.ServiceUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {
      @Autowired
    private ServiceUserRepo userRepo;
      @Autowired
    private JWTUtils utils;
      @Autowired
    private PasswordEncoder passwordEncoder;
      @Autowired
    private AuthenticationManager authenticationManager;

      public RequestResponse SignUp(RequestResponse reqres){
          RequestResponse response = new RequestResponse();
          try {
              ServiceUser user = new ServiceUser();
              user.setEmail(reqres.getEmail());
              user.setPassword(passwordEncoder.encode(reqres.getPassword()));
              user.setRole(reqres.getRole());
              ServiceUser result = userRepo.save(user);
              if(result != null && result.getId()>0){
                  response.setOurUsers(result);
                  response.setMessage("Created successfully");
                  response.setStatusCode(200);
              }
          }catch (Exception e){
                response.setStatusCode(500);
                response.setError(e.getMessage());
          }
          return response;
      }
      public RequestResponse SignIn(RequestResponse reqres){
          RequestResponse response = new RequestResponse();
          try {
              authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqres.getEmail(),reqres.getPassword()));
              var user = userRepo.findByEmail(reqres.getEmail()).orElseThrow();
              System.out.println("USER IS "+user);
              var jwt = utils.generateToken(user);
              var refreshToken = utils.generateRefreshToken(new HashMap<>(),user);
              response.setStatusCode(200);
              response.setToken(jwt);
              response.setRefreshToken(refreshToken);
              response.setExpirationDate("24hr");
              response.setMessage("Successfully signed in");
          }catch (Exception e){
              response.setStatusCode(500);
              response.setError(e.getMessage());
          }
          return response;
      }
}
