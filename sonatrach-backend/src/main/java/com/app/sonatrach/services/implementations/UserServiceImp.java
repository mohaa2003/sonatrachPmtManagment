package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.PrevisionRecrutmentDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.PrevisionRecrutment;
import com.app.sonatrach.model.User;
import com.app.sonatrach.repositories.UserRepo;
import com.app.sonatrach.services.UserService;
import com.app.sonatrach.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    private UserRepo userRepo;
    @Autowired
    public UserServiceImp(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDto save(UserDto userDto) {
        List<String> errors = UserValidator.validate(userDto);
        if (!errors.isEmpty()) {
            log.error("user not valid", userDto);
            throw new InvalidEntityException("utilisateur non valide", ErrorCodes.EMPLOYE_NOT_VALID, errors);
        }
        return UserDto.fromEntity(userRepo.save(UserDto.toEntity(userDto)));
    }

    @Override
    public UserDto findById(Integer id) {
        if(id == null){
            log.error("user non valide");
            return null;
        }
        Optional<User> user = userRepo.findById(id);
        return Optional.of(UserDto.fromEntity(user.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur est trouve avec l'id "+id+" dans la base de donnees", ErrorCodes.EMPLOYE_NOT_FOUND));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map(UserDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("user not valide");
        }
        userRepo.deleteById(id);
    }
}
