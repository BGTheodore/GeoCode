package com.example.gtm.Services;

import com.example.gtm.Repositories.InstitutionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {
    @Autowired
    InstitutionRepository repository;

    
}
