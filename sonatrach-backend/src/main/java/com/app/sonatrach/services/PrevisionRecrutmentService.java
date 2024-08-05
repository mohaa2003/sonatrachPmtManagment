package com.app.sonatrach.services;

import com.app.sonatrach.dto.PrevisionRecrutmentDto;

import java.util.List;

public interface PrevisionRecrutmentService {
    PrevisionRecrutmentDto save(PrevisionRecrutmentDto previsionRecrutmentDto);
    PrevisionRecrutmentDto findById(Integer id);
    List<PrevisionRecrutmentDto> findAll();
    void delete(Integer id);
}
