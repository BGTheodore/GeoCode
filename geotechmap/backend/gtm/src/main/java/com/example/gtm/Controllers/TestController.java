package com.example.gtm.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.Test;
import com.example.gtm.Repositories.TestRepository;
import com.example.gtm.Services.TestService;

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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tests")
public class TestController {
    @Autowired
    TestService service;
    TestRepository repository;

    //Create a test
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Test> createNewTest(@Valid @RequestBody Test test) {         
            Test createdTest = service.createNewTest(test);
            return new ResponseEntity<>(createdTest, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<List<Test>>  getAllTests(){
        return ResponseEntity.ok().body(service.listAllTests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Test>> getTest(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getTest(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Test> updateTest(@RequestBody Test test, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.updateTest(id, test));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteTest(@PathVariable Long id) {
            service.deleteTest(id);
    }
    
}
