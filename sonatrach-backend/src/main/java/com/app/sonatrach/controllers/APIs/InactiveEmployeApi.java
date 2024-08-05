package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.InactiveEmployeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface InactiveEmployeApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<InactiveEmployeDto> save(InactiveEmployeDto inactiveEmployeDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<InactiveEmployeDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<InactiveEmployeDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}
