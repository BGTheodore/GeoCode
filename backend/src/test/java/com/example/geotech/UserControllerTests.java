// package com.example.geotech;

// import static org.junit.Assert.assertEquals;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// import com.example.geotech.Entities.User;
// import com.example.geotech.Repositories.UserRepository;
// import com.example.geotech.Services.UserService;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.test.context.junit4.SpringRunner;



// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class UserControllerTests {
//     @Autowired
// 	private UserService service;

// 	@MockBean
//     private UserRepository userRepository;

// 	@Test
// 	public void getUsersTest() {
//         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//         User user = new User();
//         user.setEmail("kevindubuche@gmail.com");
//         user.setFirstName("Peter");
//         user.setLastName("Parker");
//         user.setRole(1);
//         user.setSexe(1);
//         String encodedPassword = encoder.encode("password");
//         user.setPassword(encodedPassword);

        
// 		when(userRepository.findAll()).thenReturn(Stream
// 				.of(user).collect(Collectors.toList()));
// 		assertEquals(1, service.listAllUsers().size());
// 	}
    
// }

