package com.app.sonatrach.services;

import com.app.sonatrach.dto.ProfilDto;

import java.util.List;

public interface ProfilService {
    ProfilDto save(ProfilDto profilDto);
    ProfilDto findById(Integer id);
    List<ProfilDto> findAll();
    void delete(Integer id);
}
