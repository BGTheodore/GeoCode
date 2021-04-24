package com.example.geotech.Entities;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "institutions")
@SQLDelete(sql = "UPDATE institutions SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "is_deleted is false")
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

    @Email(message = "Email non valide")
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Size(max = 255, message = "255 caractères au maximum")
    @Column(length = 255)
    private String address;

    @Size(max = 25, message = "25 caractères au maximum")
    @Column( length = 25)
    private String phone1;

    @Size(max = 25, message = "25 caractères au maximum")
    @Column( length = 25)
    private String phone2;

    @Size(max = 25, message = "25 caractères au maximum")
    @Column( length = 25)
    private String website;

    @Size(max = 25, message = "25 caractères au maximum")
    @Column( name = "last_name", length = 25)
    private String taxNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private LocalDateTime deletedAt;
    
    @Column(nullable = true)
    private Boolean isDeleted = false;
}
