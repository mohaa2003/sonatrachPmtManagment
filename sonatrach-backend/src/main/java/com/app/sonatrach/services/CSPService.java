package com.app.sonatrach.services;

import com.app.sonatrach.dto.CSPDto;

import java.util.List;

public interface CSPService {
    CSPDto save(CSPDto cspDto);
    CSPDto findById(Integer id);
    List<CSPDto> findAll();
    void delete(Integer id);
}
