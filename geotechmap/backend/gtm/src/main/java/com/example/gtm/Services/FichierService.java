package com.example.gtm.Services;

import java.io.File;
import java.io.IOException;

import com.example.gtm.Entities.Fichier;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FichierService {
   public void telechargementFichier(MultipartFile fichier) throws IllegalStateException, IOException{
       fichier.transferTo(new File("/home/kevin/Documents/kevin/EN3/PROJET_FINAL_URGEO/Spring/gtm/geotechmap/backend/gtm/src/main/java/com/example/gtm/Services"+fichier.getOriginalFilename()));//Path de destination des fichiers telecharges
   }
}
