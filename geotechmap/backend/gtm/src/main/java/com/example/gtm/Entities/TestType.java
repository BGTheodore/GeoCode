package com.example.gtm.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "test_types")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nom obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "name", nullable = false, length = 45)
    private String name;


    // @Size(min = 2, max = 10, message = "2 caractères au minimum; 10 maximum")
    @Column(name = "abbreviation", length = 10)
    private String abbreviation;

    // @Size(min = 2, max = 255, message = "2 caractères au minimum; 255 maximum")
    @Column(name = "description", length = 10)
    private String description;
}
