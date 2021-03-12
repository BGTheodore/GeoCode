package com.example.geotech.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.geotech.Entities.User;
import com.example.geotech.Repositories.UserRepository;
import com.example.geotech.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;
    UserRepository userRepository;
    
    //Create a user
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createNewUser(@Valid @RequestBody User user) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);            
            User createdUser = userService.createNewUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

 
    @GetMapping
    public  ResponseEntity<List<User>>  getAllUsers(){
        return ResponseEntity.ok().body(userService.listAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        return ResponseEntity.ok().body(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
    }


}
