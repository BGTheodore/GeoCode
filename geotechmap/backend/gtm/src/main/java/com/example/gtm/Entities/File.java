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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "coordonates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE coordonates SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted is false")

public class File extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Champs obligatoire")
    @NotEmpty(message = "Champs obligatoire")
    @Size(max = 255, message = "255 caractères au maximum")
    @Column(length = 255)
    private String link;


    @Size(max = 255, message = "255 caractères au maximum")
    @Column(length = 255)
    private String format;

    @Size(max = 255, message = "255 caractères au maximum")
    @Column(length = 255)
    private String size;

    @Column(nullable = true)
    private Boolean isDeleted = false;
}
