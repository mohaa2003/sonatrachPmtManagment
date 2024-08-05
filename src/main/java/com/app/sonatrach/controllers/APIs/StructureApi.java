package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.StructureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface StructureApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<StructureDto> save(StructureDto structureDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<StructureDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<StructureDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}
