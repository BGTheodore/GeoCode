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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "test_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE test_types SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted is false")
public class TestType extends Auditable<String>{

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

    @Size(max = 255, message = "255 caractères au maximum")
    @Column(name = "description", length = 255)
    private String description;

    @Column(nullable = true)
    private Boolean isDeleted = false;
}
