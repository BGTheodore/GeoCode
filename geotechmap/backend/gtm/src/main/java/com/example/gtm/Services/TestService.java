package com.example.gtm.Services;


import java.util.List;
import java.util.Optional;

import com.example.gtm.Entities.Test;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Repositories.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    TestRepository repository;

    public Test createNewTest(Test test) {
        return repository.save(test);
        }

    public List<Test> listAllTests() {
        return repository.findAll();
        }

    public Test updateTest(Long id, Test test) {
        Optional<Test> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("Test not found with id :" + id);
        } else {
            test.setId(id);
            return repository.save(test);
        }
    }

    public void deleteTest(Long id) {
        Optional<Test> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Test not found with id :" + id);
        } else {
            repository.deleteById(id);
        }
    }

    public Optional<Test> getTest(Long id) {
        Optional<Test> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("Test not found with id :" + id);
        } else {
        return optional;
        }
    }
}
