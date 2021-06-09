package com.example.gtm.Services;

import java.io.File;
import java.io.IOException;

import com.example.gtm.Entities.Essai;
import com.example.gtm.Entities.Fichier;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Repositories.FichierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Date;
import java.sql.Timestamp;

@Service
public class FichierService {
    @Autowired
    FichierRepository repository;

   public void telechargementFichier(MultipartFile fichier) throws IllegalStateException, IOException{
       fichier.transferTo(new File("/home/kevin/Documents/kevin/EN3/PROJET_FINAL_URGEO/Spring/gtm/geotechmap/backend/gtm/src/main/java/com/example/gtm/Services"+fichier.getOriginalFilename()));//Path de destination des fichiers telecharges
   }

   public Fichier updateFichier(Long id, Fichier fichier){
        Optional<Fichier> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Fichier not found with id :" + id );
        } else {
            fichier.setId(id);
            return repository.save(fichier);
        }
    }


    //============================

    public Fichier genererStuctureFichier(Essai essai) {
        Date date = new Date();
        String nomInitial = essai.getFichier().getNom();
        String nomUniqueDuFichier = nomInitial.substring(0, nomInitial.length() - 3)+ new Timestamp(date.getTime()) + ".pdf";
        nomUniqueDuFichier = nomUniqueDuFichier.replace(' ','-');

        //__ fin enregistrement du fichier dans server de fichier  
        if(essai.getId() != null){
            System.out.println(essai.getId());
            System.out.println("MODIFICATION");
        }else{
            System.out.println(essai.getId());
            System.out.println("CREATION");
        }
            File file = new File(nomUniqueDuFichier);
            System.out.println(nomUniqueDuFichier);
            try ( FileOutputStream fos = new FileOutputStream(file); ) {
            String b64 = essai.getPdf();
            byte[] decoder = Base64.getDecoder().decode(b64);
            fos.write(decoder); //sonje free memory
            System.out.println("PDF File Saved");
            } catch (Exception e) {
            e.printStackTrace();
            }   
        //__ fin enregistrement du fichier dans server de fichier  

        Fichier fichier = new Fichier();
        fichier.setNom(essai.getFichier().getNom());
        fichier.setCapacite(essai.getFichier().getCapacite());
        fichier.setFormat(essai.getFichier().getFormat());
        fichier.setLien("gyul");
        fichier.setHash("igutf");
       
        return fichier;
        
    }
}
