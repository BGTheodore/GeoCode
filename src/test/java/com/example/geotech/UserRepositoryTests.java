package com.example.geotech;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.geotech.Entities.User;
import com.example.geotech.Repositories.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        User user = new User();
        user.setEmail("kevindubuche@gmail.com");
        user.setFirstName("Peter");
        user.setLastName("Parker");
        user.setRole(1);
        user.setSexe(1);
        String encodedPassword = encoder.encode("password");
        user.setPassword(encodedPassword);

       User savedUser = userRepository.save(user);

       User existUser = testEntityManager.find(User.class, savedUser.getId());
       assertThat(existUser.getEmail()).isEqualTo(user.getEmail()); 
       
    }

    @Test
    public void testFindUserByEmail(){
        String email = "admin@admin.com";
        User user = userRepository.findByEmail(email);

        assertThat(user).isNotNull();
    }
}
