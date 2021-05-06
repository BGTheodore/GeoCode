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

public class Coordonate extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "x", nullable = false)
    @Digits(integer = 6, fraction = 2)
    private double x;


    @Column(name = "y", nullable = false)
    @Digits(integer = 6, fraction = 2)
    private double y;

    @Column(name = "z", nullable = false)
    @Digits(integer = 6, fraction = 2)
    private double z;

    // @OneToMany(mappedBy = "coordonate")
    // private List<Test> tests;
    
    @Column(nullable = true)
    private Boolean isDeleted = false;
}
