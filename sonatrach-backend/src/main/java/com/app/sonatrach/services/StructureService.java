package com.app.sonatrach.services;

import com.app.sonatrach.dto.StructureDto;

import java.util.List;

public interface StructureService {
    StructureDto save(StructureDto structureDto);
    StructureDto findById(Integer id);
    List<StructureDto> findAll();
    void delete(Integer id);
}
