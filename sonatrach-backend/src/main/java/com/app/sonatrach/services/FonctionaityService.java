package com.app.sonatrach.services;

import com.app.sonatrach.dto.FonctionalityDto;

import java.util.List;

public interface FonctionaityService {
    FonctionalityDto save(FonctionalityDto fonctionalityDto);
    FonctionalityDto findById(Integer id);
    List<FonctionalityDto> findAll();
    void delete(Integer id);
}
