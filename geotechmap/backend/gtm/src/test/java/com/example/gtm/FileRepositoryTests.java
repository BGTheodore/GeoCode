package com.example.gtm;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;  

import com.example.gtm.Entities.File;
import com.example.gtm.Repositories.FileRepository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileRepositoryTests {

	@MockBean
    private FileRepository repository;

    @Test
	public void getFileTest() {
        File file = new File();
        file.setLink("www.gtm.files/245456545.pdf");
        file.setFormat("PDF");
        file.setSize("1024 MB");
        
		when(repository.findAll()).thenReturn(Stream
		.of(file).collect(Collectors.toList()));
		assertEquals(1, repository.findAll().size());


	}

}
