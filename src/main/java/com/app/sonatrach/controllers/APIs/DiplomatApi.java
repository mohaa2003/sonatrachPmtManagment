package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.DiplomatDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface DiplomatApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<DiplomatDto> save(DiplomatDto diplomatDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<DiplomatDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<DiplomatDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}
