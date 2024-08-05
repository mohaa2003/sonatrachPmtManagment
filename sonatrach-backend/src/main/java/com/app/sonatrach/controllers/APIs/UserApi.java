package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface UserApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<UserDto> save(UserDto userDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<UserDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<UserDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}
