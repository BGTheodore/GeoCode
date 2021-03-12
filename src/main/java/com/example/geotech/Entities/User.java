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
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Email non valide")
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    // @Pattern(regexp = "^[ABC]$", message = "Must be either A, B or C")
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private Integer role;

    @NotNull
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @NotNull
    @NotEmpty(message = "Champs obligatoire")
    @Size(min = 2, max = 45, message = "2 caractères au minimum; 45 maximum")
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @NotNull
    @Column(nullable = false)
    private Integer sexe;

    @Size(max = 25, message = "25 caractères au maximum")
    @Column( length = 25)
    private String phone;

    @Size(max = 255, message = "255 caractères au maximum")
    @Column(length = 255)
    private String address;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

