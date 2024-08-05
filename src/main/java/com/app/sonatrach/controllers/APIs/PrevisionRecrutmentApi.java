package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.PrevisionRecrutmentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface PrevisionRecrutmentApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<PrevisionRecrutmentDto> save(PrevisionRecrutmentDto previsionRecrutmentDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<PrevisionRecrutmentDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<PrevisionRecrutmentDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}
