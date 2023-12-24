package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUSerById(Long id){
        return userRepository.findById(id);
    }

    public User updateUser(User user) {
        // Check if the user with the given ID exists
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        } else {
            // Handle the case where the user with the given ID doesn't exist
            throw new RuntimeException("User not found with ID: " + user.getId());
        }
    }


}
