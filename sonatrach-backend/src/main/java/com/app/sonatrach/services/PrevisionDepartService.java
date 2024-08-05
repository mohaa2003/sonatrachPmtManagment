package com.app.sonatrach.services;

import com.app.sonatrach.dto.PrevisionDepartDto;

import java.util.List;

public interface PrevisionDepartService {
    PrevisionDepartDto save(PrevisionDepartDto previsionDepartDto);
    PrevisionDepartDto findById(Integer id);
    List<PrevisionDepartDto> findAll();
    void confirmDepart(Integer id);
    void inconfirmDepart(Integer id);
    void delete(Integer id);
}
