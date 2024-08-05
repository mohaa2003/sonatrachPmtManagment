package com.app.sonatrach.services;

import com.app.sonatrach.dto.InactiveEmployeDto;

import java.util.List;

public interface InactiveEmployeService {
    InactiveEmployeDto save(InactiveEmployeDto inactiveEmployeDto);
    InactiveEmployeDto findById(Integer id);
    List<InactiveEmployeDto> findAll();
    void delete(Integer id);
}
