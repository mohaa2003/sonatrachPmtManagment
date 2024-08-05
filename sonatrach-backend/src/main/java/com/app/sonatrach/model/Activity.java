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
@Table(name = "activite")
public class Activity extends SuperEntity{

    @Column(name = "code" ,nullable = false,unique = true)
    private String code;

    @Column(name = "titre" ,nullable = false)
    private String titre;

    @Enumerated(EnumType.STRING)
    @Column(name = "categorie" ,nullable = false)
    private CatgoryActivity category;

    @OneToMany(mappedBy = "activity",cascade = CascadeType.ALL)
    private List<Fonctionality> Fonctionalities;

}
