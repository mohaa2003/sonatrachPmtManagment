package com.app.sonatrach.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class SuperEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @CreatedDate
//    @Column(name = "date_de_creation",nullable = false)
//    @JsonIgnore
//    private Instant creationDate;
//
//    @CreatedDate
//    @Column(name = "date_de_derniere_modification",nullable = false)
//    @JsonIgnore
//    private Instant lastModifitionDate;
}
