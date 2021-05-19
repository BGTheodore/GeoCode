package com.example.gtm.Controllers;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.TypeEssai;
import com.example.gtm.Repositories.TypeEssaiRepository;
import com.example.gtm.Services.TypeEssaiService;

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
@RequestMapping("/api/type_essais")
@CrossOrigin(origins = "http://localhost:3000")
public class TypeEssaiController {
    @Autowired
    TypeEssaiService service;
    TypeEssaiRepository repository;

    //Create a TypeEssai
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TypeEssai> createNewTypeEssai(@Valid @RequestBody TypeEssai typeEssai) {         
            TypeEssai createdTypeEssai = service.createNewTypeEssai(typeEssai);
            return new ResponseEntity<>(createdTypeEssai, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<List<TypeEssai>>  getAllTypeEssais(){
        return ResponseEntity.ok().body(service.listAllTypeEssais());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeEssai> getTypeEssai(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getTypeEssai(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TypeEssai> updateTypeEssai(@RequestBody TypeEssai typeEssai, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.updateTypeEssai(id, typeEssai));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteTypeEssai(@PathVariable Long id) {
            service.deleteTypeEssai(id);
    }
    
}
