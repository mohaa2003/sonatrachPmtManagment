package com.app.sonatrach.services;

import com.app.sonatrach.dto.PMTDto;

import java.time.Instant;
import java.util.List;

public interface PMTService {
    PMTDto save(PMTDto pmtDto); //n'oublie pas le processus de l'ajout d'une prevision
    PMTDto findById(Integer id);
    List<PMTDto> findAll();
    void delete(Integer id);
}
