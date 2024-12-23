package com.example.store.service;

import com.example.store.model.UserDemo;
import com.example.store.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDemo createUser(UserDemo user) {
        return userRepository.save(user);
    }

    public List<UserDemo> getUsers() {
        return userRepository.findAll();
    }

    public UserDemo getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User hasn't been found!"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
