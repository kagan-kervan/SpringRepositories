package com.example.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User SignUp(User user){
        return userRepository.save(user);
    }
    public User signIn(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }

    public List<User> GetAllUsers(){
        return userRepository.findAll();
    }

    public User GetByID(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public User DeleteUser(Long id){
        User u = GetByID(id);
        if(u != null){
            userRepository.delete(u);
        }
        return u;
    }
}
