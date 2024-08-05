package com.app.sonatrach.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prevision_de_recrutement")
public class PrevisionRecrutment extends SuperEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "niveau_requis",nullable = false)
    private Niveau requiredLevel ;

    @Column(name = "experience",nullable = false)
    private Integer experience ;

    @Column(name = "Spécificités")
    private String posteRequirments ;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_de_recrutement",nullable = false)
    private TypeRecrut type ;

    @ManyToOne
    @JoinColumn(name = "id_diplome")
    private Diplomat diplomat;

    @ManyToOne
    @JoinColumn(name = "id_fonctionalite")
    private Fonctionality fonctionality;

    @ManyToOne
    @JoinColumn(name = "id_pmt")
    private PMT pmt;
}
