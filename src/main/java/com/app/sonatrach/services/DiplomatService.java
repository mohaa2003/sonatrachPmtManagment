package com.app.sonatrach.services;

import com.app.sonatrach.dto.DiplomatDto;

import java.util.List;

public interface DiplomatService {
    DiplomatDto save(DiplomatDto diplomatDto);
    DiplomatDto findById(Integer id);
    List<DiplomatDto> findAll();
    void delete(Integer id);
}
