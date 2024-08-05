package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.FonctionalityDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface FonctionaityApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<FonctionalityDto> save(FonctionalityDto fonctionalityDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<FonctionalityDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<FonctionalityDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}
