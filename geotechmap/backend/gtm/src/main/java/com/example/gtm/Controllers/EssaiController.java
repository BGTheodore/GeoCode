package com.example.gtm.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.Essai;
import com.example.gtm.Entities.Fichier;
import com.example.gtm.Entities.Position;
import com.example.gtm.Repositories.EssaiRepository;
import com.example.gtm.Repositories.FichierRepository;
import com.example.gtm.Services.EssaiService;
import com.example.gtm.Services.FichierService;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/essais")
public class EssaiController {
    @Autowired
    EssaiService service;
    EssaiRepository repository;
    // @Autowired
    // FichierService fichierService;
    @Autowired
    FichierRepository fichierRepository;

    //Create a test
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public
    // void
    ResponseEntity<Essai> 
    createNewEssai(
        @RequestBody @Valid Essai essai
        // @RequestPart("file") MultipartFile fichier
        // @RequestParam("file") MultipartFile fichier
        // ,
        //  @Valid @ModelAttribute Essai essai 
        
        ){     
            System.out.println(essai.getFichier().getNom());
            
            File file = new File("./testoqqq.pdf");
            try ( FileOutputStream fos = new FileOutputStream(file); ) {
              String b64 = essai.getPdf();
              byte[] decoder = Base64.getDecoder().decode(b64);
              fos.write(decoder);
              System.out.println("PDF File Saved");
            } catch (Exception e) {
              e.printStackTrace();
            }    

            //__creation du fichier
                Fichier fichier = new Fichier();
                fichier.setNom(essai.getFichier().getNom());
                fichier.setCapacite(essai.getFichier().getCapacite());
                fichier.setFormat(essai.getFichier().getFormat());
                fichier.setLien("gyul");
                fichier.setHash("igutf");
                fichierRepository.save(fichier);
            //__fin creation du fichier

            // fichierService.telechargementFichier(fichier);
            //__créons d'abord le point géographique:
                GeometryFactory geometryFactory = new GeometryFactory();
                Coordinate coordinate = new Coordinate(essai.getPosition().getAltitude(), essai.getPosition().getLongitude());
                Point point = geometryFactory.createPoint(coordinate);
                point.setSRID(3857);//Nous devons choisir un SRID (old 4326) WGS84
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
    public ResponseEntity<Essai> getEssai(@PathVariable Long id){
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

    @GetMapping(path = "/search")
    public  ResponseEntity<List<Essai>>  rechercheParmotsCles(@RequestParam String mot_cle){
        //trim mot_cle
        return ResponseEntity.ok().body(service.rechercheParmotsCles(mot_cle));
    }

}
