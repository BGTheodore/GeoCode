package com.example.gtm.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.Essai;
import com.example.gtm.Entities.Position;
import com.example.gtm.Repositories.EssaiRepository;
import com.example.gtm.Services.EssaiService;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
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
@RequestMapping("/api/essais")
public class EssaiController {
    @Autowired
    EssaiService service;
    EssaiRepository repository;

    //Create a test
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Essai> createNewEssai(@Valid @RequestBody Essai essai) {         
           
            //__créons d'abord le point géographique:
                GeometryFactory geometryFactory = new GeometryFactory();
                Coordinate coordinate = new Coordinate(essai.getPosition().getAltitude(), essai.getPosition().getLongitude());
                Point point = geometryFactory.createPoint(coordinate);
                point.setSRID(3857);//Nous devont choisir un SRID (old 4326)
                Position position = essai.getPosition();
                position.setGeom(point);
                essai.setPosition(position);
            //__fin créationpoint géographique:
            Essai createdEssai = service.createNewEssai(essai);
            return new ResponseEntity<>(createdEssai, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<List<Essai>>  getAllEssais(){
        return ResponseEntity.ok().body(service.listAllEssais());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Essai>> getEssai(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getEssai(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Essai> updateEssai(@RequestBody Essai essai, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.updateEssai(id, essai));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteEssai(@PathVariable Long id) {
            service.deleteEssai(id);
    }

}
