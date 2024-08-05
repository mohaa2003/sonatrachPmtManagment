package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.PMTDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface PMTApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<PMTDto> save(PMTDto pmtDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<PMTDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<PMTDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}
