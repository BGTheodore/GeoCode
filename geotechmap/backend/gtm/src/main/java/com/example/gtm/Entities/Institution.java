package com.example.gtm.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "institutions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE institutions SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted is false")

public class Institution extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Size( max = 10, message = "10 caractères au maximum")
    @Column(name = "acronym", length = 45)
    private String acronym;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 255 maximum")
    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 3, max = 45, message = "3 caractères au minimum; 45 maximum")
    @Column(name = "phone1", nullable = false, length = 45)
    private String phone1;

    @Size(min = 3, max = 45, message = "3 caractères au minimum; 45 maximum")
    @Column(name = "phone2", nullable = false, length = 45)
    private String phone2;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 6, max = 45, message = "6 caractères au minimum; 45 maximum")
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "website", nullable = false, length = 45)
    private String website;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "tax_number", nullable = false, length = 45)
    private String taxNumber;

    @Size(max = 255, message = "255 caractères au maximum")
    @Column(name = "description", length = 255)
    private String description;

    // @OneToMany(mappedBy = "testType")
    // private List<Test> tests;
    
    @Column(nullable = true)
    private Boolean isDeleted = false;

}
