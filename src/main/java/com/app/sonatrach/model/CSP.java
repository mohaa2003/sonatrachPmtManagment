package com.app.sonatrach.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CSP extends SuperEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "intitule" ,nullable = false,unique = true)
    private TypeCSP type;

    @Column(name = "echelle_maximum" ,nullable = false)
    private Integer maxEchelle;

    @Column(name = "echelle_minimum" ,nullable = false)
    private Integer minEchelle;

    @Enumerated(EnumType.STRING)
    @Column(name = "categorie" ,nullable = false)
    private CategoryCSP category;

    @OneToMany(mappedBy = "csp",cascade = CascadeType.ALL)
    private List<Employe> employes;
}
