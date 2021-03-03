package com.example.geotech;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.geotech.Entities.User;
import com.example.geotech.Repositories.UserRepositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepositories userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("admin@admin.com");
        user.setPassword("password");
        user.setFirstName("Peter");
        user.setLastName("Parker");

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
