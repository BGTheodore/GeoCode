package com.example.gtm;

import com.example.gtm.Entities.Institution;
import com.example.gtm.Repositories.InstitutionRepository;
import com.example.gtm.Services.InstitutionService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) 
@SpringBootTest
class InstitutionRepositoryTest {
    @Autowired
    private InstitutionService service;

    @idMockBean
    private InstitutionRepository repository;

    @Test
}
