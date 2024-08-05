package com.app.sonatrach.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prevision_de_depart")
public class PrevisionDepart extends SuperEntity{

    @Column(name = "annee",nullable = false)
    private Instant annee ;

    @Enumerated(EnumType.STRING)
    @Column(name = "motif",nullable = false)
    private MotifDepart motif ;

    @Column(name = "confermation_de_depart",nullable = false)
    private Boolean isConfirmed = false ;

    private String observation ;

    @ManyToOne
    @JoinColumn(name = "id_pmt")
    private PMT pmt;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;
}
