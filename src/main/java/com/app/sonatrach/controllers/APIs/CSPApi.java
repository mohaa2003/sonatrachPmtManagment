package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.CSPDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface CSPApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<CSPDto> save(CSPDto cspDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<CSPDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<CSPDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}
