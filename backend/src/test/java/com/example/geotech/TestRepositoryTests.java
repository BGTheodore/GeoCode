// package com.example.geotech;
// import static org.junit.Assert.assertEquals;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// import com.example.geotech.Entities.TestType;
// import com.example.geotech.Entities.Test;
// import com.example.geotech.Repositories.TestRepository;
// import com.example.geotech.Repositories.TestTypeRepository;
// import com.example.geotech.Services.TestService;
// import com.example.geotech.Services.TestTypeService;

// // import org.junit.Test ;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.junit4.SpringRunner;



// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class TestRepositoryTests {
//     @Autowired
// 	private TestService testService;

// 	@MockBean
//     private TestRepository TestRepository;

//     @org.junit.Test
//     public void whenSaveOneToManyRelationship_thenCorrect() {
//         TestType testType = new TestType();
//         testType.setName("Teneur en eau");

//         Test test1 = new Test();
//         Test test2 = new Test();
//         test1.setTestType(testType);
//         test2.setTestType(testType);

//         when(TestRepository.findAll()).thenReturn(Stream
//         .of(test1).collect(Collectors.toList()));
//         assertEquals(1, testService.listAllTests().size());
//     }
// }
