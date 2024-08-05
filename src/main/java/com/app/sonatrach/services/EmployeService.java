package com.app.sonatrach.services;

import com.app.sonatrach.dto.EmployeDto;

import java.util.List;

public interface EmployeService {
    EmployeDto save(EmployeDto employeDto);
    EmployeDto findById(Integer id);
    List<EmployeDto> findAll();
    List<EmployeDto> findAllActives();
    void delete(Integer id);
}
