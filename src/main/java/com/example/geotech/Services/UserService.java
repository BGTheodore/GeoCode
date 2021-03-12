package com.example.geotech.Services;

import java.util.List;
import java.util.Optional;

import com.example.geotech.Entities.User;
import com.example.geotech.Exception.ResourceNotFoundException;
import com.example.geotech.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User createNewUser(User user) {
        return userRepository.save(user);
        }

    public List<User> listAllUsers() {
        return userRepository.findAll();
        }

    public User updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
        throw new ResourceNotFoundException("User not found with id :" + id);
        } else {
        return userRepository.save(user);
        }
        }

    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("User not found with id :" + id);
        } else {
        userRepository.deleteById(id);
        }
        }

    public Optional<User> getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
        throw new ResourceNotFoundException("User not found with id :" + id);
        } else {
        return userOptional;
        }
    }
}

