package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.DiplomatDto;
import com.app.sonatrach.dto.EmployeDto;
import com.app.sonatrach.dto.ProfilDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.Diplomat;
import com.app.sonatrach.model.User;
import com.app.sonatrach.repositories.CSPRepo;
import com.app.sonatrach.repositories.DiplomatRepo;
import com.app.sonatrach.services.DiplomatService;
import com.app.sonatrach.validators.DiplomatValidator;
import com.app.sonatrach.validators.ProfilValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DiplomatServiceImp implements DiplomatService {
    @Autowired
    private DiplomatRepo diplomatRepo;
    @Override
    public DiplomatDto save(DiplomatDto diplomatDto) {
        List<String> errors = DiplomatValidator.validate(diplomatDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("diplome non valide", ErrorCodes.DIOLOMAT_NOT_VALID, errors);
        }
        return DiplomatDto.fromEntity(diplomatRepo.save(DiplomatDto.toEntity(diplomatDto)));

    }

    @Override
    public DiplomatDto findById(Integer id) {

        if(id == null){
            log.error("diplome non valide");
            return null;
        }
        Optional<Diplomat> diplomat = diplomatRepo.findById(id);
        return Optional.of(DiplomatDto.fromEntity(diplomat.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucune diplome est trouve avec l'id "+id+" dans la base de donnees", ErrorCodes.DIOLOMAT_NOT_FOUND));

    }

    @Override
    public List<DiplomatDto> findAll() {

        return diplomatRepo.findAll().stream()
                .map(DiplomatDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("diplome not valide");
        }
        diplomatRepo.deleteById(id);

    }
}
