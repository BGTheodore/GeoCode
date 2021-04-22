package com.example.geotech.Services;

import java.util.List;
import java.util.Optional;

import com.example.geotech.Entities.TestType;
import com.example.geotech.Exception.ResourceNotFoundException;
import com.example.geotech.Repositories.TestTypeRepository;

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
