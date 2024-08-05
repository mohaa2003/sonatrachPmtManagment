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
@Table(name = "structure")
public class Structure extends SuperEntity{

    @Column(name = "designation",nullable = false,unique = true)
    private String designation ;

    @Enumerated(EnumType.STRING)
    @Column(name = "wilaya",nullable = false)
    private Wilaya lieu ;

    @OneToMany(mappedBy = "structure",cascade = CascadeType.ALL)
    private List<Employe> employes;

    @OneToMany(mappedBy = "structureDest",cascade = CascadeType.ALL)
    private List<InactiveEmploye> mutedEmployes;
}
