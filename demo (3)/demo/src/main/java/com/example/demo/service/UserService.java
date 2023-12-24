package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser (User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById (Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> updateDataById(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            // Update properties based on your requirements

            user.setId(id);
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            // Add more fields to update as needed

            return userRepository.update(user);
        });
    }

}
