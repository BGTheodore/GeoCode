package com.example.gtm.Controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.Essai;
import com.example.gtm.Entities.Fichier;
import com.example.gtm.Entities.Position;
import com.example.gtm.Repositories.EssaiRepository;
import com.example.gtm.Repositories.FichierRepository;
import com.example.gtm.Repositories.PositionRepository;
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
import java.util.Date;


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
    @Autowired
    PositionRepository positionRepository;

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
            //__creation du fichier dans server de fichier 
            Date date = new Date();
            String nomInitial = essai.getFichier().getNom();
            String nomUniqueDuFichier = nomInitial.substring(0, nomInitial.length() - 3)+ new Timestamp(date.getTime()) + ".pdf";
            nomUniqueDuFichier = nomUniqueDuFichier.replace(' ','-');

            File file = new File(nomUniqueDuFichier);
            System.out.println(nomUniqueDuFichier);
            try ( FileOutputStream fos = new FileOutputStream(file); ) {
              String b64 = essai.getPdf();
              byte[] decoder = Base64.getDecoder().decode(b64);
              fos.write(decoder);
              System.out.println("PDF File Saved");
            } catch (Exception e) {
              e.printStackTrace();
            }   
            //__ fin creation du fichier dans server de fichier  

            //__creation du fichier dans la BD
                Fichier fichier = new Fichier();
                fichier.setNom(essai.getFichier().getNom());
                fichier.setCapacite(essai.getFichier().getCapacite());
                fichier.setFormat(essai.getFichier().getFormat());
                fichier.setLien("gyul");
                fichier.setHash("igutf");
                fichierRepository.save(fichier);
            //__fin creation du fichier dans la BD

            //__création de positiion géographique:
                GeometryFactory geometryFactory = new GeometryFactory();
                Coordinate coordinate = new Coordinate(essai.getPosition().getLatitude(), essai.getPosition().getLongitude());
                Point point = geometryFactory.createPoint(coordinate);
                point.setSRID(3857);//Nous devons choisir un SRID (old 4326) WGS84
                Position position = essai.getPosition();
                position.setGeom(point);
                position.setLatitude(essai.getPosition().getLatitude());
                position.setLongitude(essai.getPosition().getLongitude());
                position.setAltitude(essai.getPosition().getAltitude());
                position.setDepartement(essai.getPosition().getDepartement());
                position.setCommune(essai.getPosition().getCommune());
                position.setSectionCommunale(essai.getPosition().getSectionCommunale());
                positionRepository.save(position);
            //__fin création de positiion géographique:


            // fichierService.telechargementFichier(fichier);
          

            essai.setPosition(position);
            essai.setFichier(fichier);
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
