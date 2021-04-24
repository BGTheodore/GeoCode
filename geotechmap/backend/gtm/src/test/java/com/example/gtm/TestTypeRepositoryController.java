package com.example.gtm;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;  

import com.example.gtm.Entities.TestType;
import com.example.gtm.Repositories.TestTypeRepository;
import com.example.gtm.Services.TestTypeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTypeRepositoryController {
    @Autowired
	private TestTypeService service;

	@MockBean
    private TestTypeRepository repository;

    @Test
	public void getTestTypeTest() {
        TestType testType = new TestType();
        testType.setName("Teneur en eau");
        
		when(repository.findAll()).thenReturn(Stream
				.of(testType).collect(Collectors.toList()));
		assertEquals(1, service.listAllTestTypes().size());
	}

}
