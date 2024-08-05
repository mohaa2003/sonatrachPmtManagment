package com.app.sonatrach.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class User extends Employe{
    @Column(name = "mot_de_passe",nullable = false)
    private String password = "SONATRACH" ;

    @Column(name = "image",nullable = false)
    private String image ;

    @ManyToOne
    @JoinColumn(name = "id_profil")
    private Profil profil;
}
