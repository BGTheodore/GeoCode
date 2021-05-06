package com.example.gtm.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tests")
@SQLDelete(sql = "UPDATE tests SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "is_deleted is false")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type")
    private TestType testType; 

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_institution")
    private Institution institution; 

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_coordonate")
    private Coordonate coordonate; 

    @Size(max = 255, message = "255 caractères au maximum")
    @Column(length = 255)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_file")
    private File file;

    @Column(nullable = true)
    private Boolean isDeleted = false;
}
