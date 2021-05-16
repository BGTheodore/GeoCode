package com.example.gtm.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "essais")
@SQLDelete(sql = "UPDATE essais SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "is_deleted is false")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Essai extends Auditable<String>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type_essai")
    private TypeEssai typeEssai; 

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_institution")
    private Institution institution; 

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_position")
    private Position position; 

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fichier")
    private Fichier fichier;
}
