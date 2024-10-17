package com.example.AuthUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/get")
    public ResponseEntity<List<User>> GetAllUsers(){
        return ResponseEntity.ok(userService.GetAllUsers());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<User> GetByID(@PathVariable Long id){
        return ResponseEntity.ok(userService.GetByID(id));
    }

    @PutMapping("/signup")
    public ResponseEntity<User> SignUp(@RequestBody User user){
        return ResponseEntity.ok(userService.SignUp(user));
    }
    @PostMapping("/signin")
    public ResponseEntity<User> SignIn(@RequestParam String username, @RequestParam String password){
        return ResponseEntity.ok(userService.signIn(username,password));
    }
}
