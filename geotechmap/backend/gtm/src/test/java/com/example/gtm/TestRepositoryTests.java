package com.example.gtm;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.gtm.Entities.TestType;
import com.example.gtm.Entities.Coordonate;
import com.example.gtm.Entities.File;
import com.example.gtm.Entities.Institution;
import com.example.gtm.Entities.Test;
import com.example.gtm.Repositories.TestRepository;
import com.example.gtm.Services.TestService;

// import org.junit.Test ;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepositoryTests {
    @Autowired
	private TestService testService;

	@MockBean
    private TestRepository TestRepository;

    @org.junit.Test
    public void whenSaveOneToManyRelationship_thenCorrect() {
        TestType testType = new TestType();
        testType.setName("Teneur en eau");

        Institution institution = new Institution();
        institution.setName("LNBTP");

        Coordonate coordonate = new Coordonate();
        coordonate.setX(1.2);

        File file = new File();
        file.setLink("www.da.com/6783.pdf");

        Test test1 = new Test();
        // Test test2 = new Test();
        // test2.setTestType(testType);
        test1.setTestType(testType);
        test1.setInstitution(institution);
        test1.setCoordonate(coordonate);
        test1.setAddress("Delmas 33");
        test1.setFile(file);

        when(TestRepository.findAll()).thenReturn(Stream
        .of(test1).collect(Collectors.toList()));
        assertEquals(1, testService.listAllTests().size());
    }
}
