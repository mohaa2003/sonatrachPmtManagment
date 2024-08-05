package com.app.sonatrach.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diplome")
public class Diplomat extends SuperEntity{

    @Column(name = "code" ,nullable = false,unique = true)
    private String code;

    @Column(name = "titre" ,nullable = false)
    private String titre;

    @Column(name = "specialite" ,nullable = true)
    private String specialite;

    @Column(name = "type" ,nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "niveau" ,nullable = false)

    private Niveau niveau;

    @OneToMany(mappedBy = "diplomat",cascade = CascadeType.ALL)
    private List<PrevisionRecrutment> previsionRecrutments ;

    @OneToMany(mappedBy = "diplomat",cascade = CascadeType.ALL)
    private List<Employe> employes;
}
