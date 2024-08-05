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
@Table(name = "employe_non_actif")
public class InactiveEmploye extends Employe{
    @Column(name = "annee_de_depart",nullable = false)
    private Instant departYear ;
    @Enumerated(EnumType.STRING)
    @Column(name = "motif")
    private MotifDepart motif;
    @ManyToOne
    @JoinColumn(name = "id_structureDest")
    private Structure structureDest;
}
