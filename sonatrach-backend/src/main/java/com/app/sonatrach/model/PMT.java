package com.app.sonatrach.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pmt")
public class PMT extends SuperEntity{

    @Column(name = "annee_de_debut",nullable = false ,unique = true)
    private Instant aneeDebut ;

    @Column(name = "duree",nullable = false)
    private Integer duration = 4 ;

    @OneToMany(mappedBy = "pmt",cascade = CascadeType.ALL)
    private List<PrevisionRecrutment> previsionRecrutments;

    @OneToMany(mappedBy = "pmt",cascade = CascadeType.ALL)
    private List<PrevisionDepart> previsionDeparts;
}
