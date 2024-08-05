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
@Inheritance(strategy = InheritanceType.JOINED)

public class Employe extends SuperEntity{

    @Column(name = "matricule" ,nullable = false,unique = true)
    private String matricule;

    @Column(name = "nom" ,nullable = false)
    private String nom;

    @Column(name = "prenom" ,nullable = false)
    private String prenom;

    @Column(name = "date_de_naissance" ,nullable = false)
    private Instant dateNaissance;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexe" ,nullable = false)
    private Sexe sexe;

    @Column(name = "date_de_recrutement" ,nullable = false)
    private Instant dateRect;

    @Column(name = "desactive" ,nullable = false)
    private boolean desactive = false;

    @Column(name = "experience" ,nullable = false)
    private Integer experience;

    @Column(name = "echelle" ,nullable = false)
    private Integer echelle;

    @ManyToOne
    @JoinColumn(name = "id_diplome")
    private Diplomat diplomat;

    @ManyToOne
    @JoinColumn(name = "id_fonctionalite")
    private Fonctionality fonctionality;

    @ManyToOne
    @JoinColumn(name = "id_csp")
    private CSP csp;

    @ManyToOne
    @JoinColumn(name = "id_structure")
    private Structure structure;

    @OneToMany(mappedBy = "employe")
    private List<PrevisionDepart> previsionDeparts;

    public boolean getDesactive() {
        return this.desactive;
    }
}
