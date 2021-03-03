package com.example.geotech.Controllers;

import java.util.List;

import com.example.geotech.Entities.User;
import com.example.geotech.Repositories.UserRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepositories userRepository;

    @GetMapping("")
    public String viewHomePAge() {
        return "users/index";
    }

    @GetMapping("/register")
    public String showSignUpForm (Model model) {
    model.addAttribute("user", new User());
    return "users/create";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("########"+user.getPassword());
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "/users/index";
    }

    @GetMapping("list_users")
    public String viewUsersList(Model model){
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users/table";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id,  User user, 
    BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "users/edit";
        }
            
        userRepository.save(user);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/";
    }

}
