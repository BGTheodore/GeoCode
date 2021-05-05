package com.example.gtm;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;  

import com.example.gtm.Entities.Coordonate;
import com.example.gtm.Repositories.CoordonateRepository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoordonateRepositoryTests {

	@MockBean
    private CoordonateRepository repository;

    @Test
	public void getCoordonateTest() {
        Coordonate coordonate = new Coordonate();
        coordonate.setX(1.2);;
        coordonate.setY(2.3);
        coordonate.setZ(3.4);
        
		when(repository.findAll()).thenReturn(Stream
		.of(coordonate).collect(Collectors.toList()));
		assertEquals(1, repository.findAll().size());


	}

}
