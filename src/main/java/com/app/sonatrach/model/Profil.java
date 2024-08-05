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
@Table(name = "profil")
public class Profil extends SuperEntity{

    @Column(name = "titre",nullable = false,unique = true)
    public String titre;

    @OneToMany(mappedBy = "profil",cascade = CascadeType.ALL)
    public List<User> users;
}
