package com.example.gtm.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "institution")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    // A ajouter dans le document
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "sigle", nullable = false, length = 45)
    private String sigle;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 255 maximum")
    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "phone", nullable = false, length = 45)
    private String phone1;

    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "phone", nullable = false, length = 45)
    private String phone2;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "website", nullable = false, length = 45)
    private String website;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "taxnumber", nullable = false, length = 45)
    private String taxnumber;

    @Column(name = "description", length = 10)
    private String description;
}
