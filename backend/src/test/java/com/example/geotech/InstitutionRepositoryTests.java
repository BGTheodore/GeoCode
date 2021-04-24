// package com.example.geotech;
// import static org.junit.Assert.assertEquals;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// import com.example.geotech.Entities.Institution;
// import com.example.geotech.Repositories.InstitutionRepository;
// import com.example.geotech.Services.InstitutionService;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.junit4.SpringRunner;



// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class InstitutionRepositoryTests {
//     @Autowired
// 	private InstitutionService service;

// 	@MockBean
//     private InstitutionRepository repository;

//     @Test
// 	public void getInstitutionsTest() {
//         Institution institution = new Institution();
//         institution.setEmail("kevindubuche@gmail.com");
//         institution.setName("LNBTP");
//         institution.setAddress("Delmas 33");
//         institution.setPhone1("50936547896");
//         institution.setPhone2("50938943678");
//         institution.setWebsite("www.lnbtm.com");
//         institution.setTaxNumber("6516545");

        
// 		when(repository.findAll()).thenReturn(Stream
// 				.of(institution).collect(Collectors.toList()));
// 		assertEquals(1, service.listAllInstitutions().size());
// 	}

// }
