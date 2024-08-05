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
@Table(name = "fonctionalite")
public class Fonctionality extends SuperEntity{

    @Column(name = "intitule",nullable = false,unique = true)
    private String intitule ;

    @Column(name = "echelle_de_base",nullable = false)
    private Integer baseEchelle ;

    @OneToMany(mappedBy = "fonctionality",cascade = CascadeType.ALL)
    private List<PrevisionRecrutment> previsionRecrutments;

    @ManyToOne
    @JoinColumn(name = "id_activite")
    private Activity activity;
}
