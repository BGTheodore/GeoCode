package com.example.gtm.Controllers;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.TestType;
import com.example.gtm.Repositories.TestTypeRepository;
import com.example.gtm.Services.TestTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/testtypes")
@CrossOrigin(origins = "http://localhost:3000")
public class TestTypeController {
    @Autowired
    TestTypeService service;
    TestTypeRepository repository;

    //Create a TestType
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TestType> createNewTestType(@Valid @RequestBody TestType testType) {         
            TestType createdTestType = service.createNewTestType(testType);
            return new ResponseEntity<>(createdTestType, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<List<TestType>>  getAllTestTypes(){
        return ResponseEntity.ok().body(service.listAllTestTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TestType>> getTestType(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getTestType(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TestType> updateTestType(@RequestBody TestType testType, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.updateTestType(id, testType));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteTestType(@PathVariable Long id) {
            service.deleteTestType(id);
    }
    
}
