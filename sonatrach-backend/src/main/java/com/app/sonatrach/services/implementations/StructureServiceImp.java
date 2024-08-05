package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.EmployeDto;
import com.app.sonatrach.dto.StructureDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.Structure;
import com.app.sonatrach.model.User;
import com.app.sonatrach.repositories.CSPRepo;
import com.app.sonatrach.repositories.StructureRepo;
import com.app.sonatrach.services.StructureService;
import com.app.sonatrach.validators.StructureValidator;
import com.app.sonatrach.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StructureServiceImp implements StructureService {
    @Autowired
    private StructureRepo structureRepo;
    @Override
    public StructureDto save(StructureDto structureDto) {
        List<String> errors = StructureValidator.validate(structureDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("structure non valide", ErrorCodes.FONCTIONALITY_NOT_VALID, errors);
        }
        return StructureDto.fromEntity(structureRepo.save(StructureDto.toEntity(structureDto)));

    }

    @Override
    public StructureDto findById(Integer id) {
        if(id == null){
            log.error("structure non valide");
            return null;
        }
        Optional<Structure> structure = structureRepo.findById(id);
        return Optional.of(StructureDto.fromEntity(structure.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun structure est trouve avec l'id "+id+" dans la base de donnees", ErrorCodes.EMPLOYE_NOT_FOUND));

    }

    @Override
    public List<StructureDto> findAll() {
        return structureRepo.findAll().stream()
                .map(StructureDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("structure not valide");
        }
        structureRepo.deleteById(id);

    }
}
