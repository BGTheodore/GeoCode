package com.example.gtm.Services;

import java.util.List;
import java.util.Optional;

import com.example.gtm.Entities.TestType;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Repositories.TestTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTypeService {
    @Autowired
    TestTypeRepository repository;

    public TestType createNewTestType(TestType testType) {
        return repository.save(testType);
        }

    public List<TestType> listAllTestTypes() {
        return repository.findAll();
        }
    
    public TestType updateTestType(Long id, TestType testType) {
        Optional<TestType> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("TestType not found with id :" + id);
        } else {
            testType.setId(id);
            return repository.save(testType);
        }
    }

    public void deleteTestType(Long id) {
        Optional<TestType> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("TestType not found with id :" + id);
        } else {
            repository.deleteById(id);
        }
    }

    public Optional<TestType> getTestType(Long id) {
        Optional<TestType> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("TestType not found with id :" + id);
        } else {
        return optional;
        }
    }
}
