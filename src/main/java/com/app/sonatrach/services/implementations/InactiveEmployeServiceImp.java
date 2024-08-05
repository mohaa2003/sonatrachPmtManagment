package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.EmployeDto;
import com.app.sonatrach.dto.InactiveEmployeDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.Employe;
import com.app.sonatrach.model.InactiveEmploye;
import com.app.sonatrach.repositories.EmployeRepo;
import com.app.sonatrach.repositories.InactiveEmployeRepo;
import com.app.sonatrach.services.InactiveEmployeService;
import com.app.sonatrach.validators.EmployeValidator;
import com.app.sonatrach.validators.InactiveEmployeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InactiveEmployeServiceImp implements InactiveEmployeService {

    private InactiveEmployeRepo inactiveEmployeRepo;
    @Autowired
    public InactiveEmployeServiceImp(InactiveEmployeRepo inactiveEmployeRepo){
        this.inactiveEmployeRepo = inactiveEmployeRepo;
    }
    @Override
    public InactiveEmployeDto save(InactiveEmployeDto inactiveEmployeDto) {
        List<String> errors = InactiveEmployeValidator.validate(inactiveEmployeDto);
        if(!errors.isEmpty()){
            log.error("Employe not valid",inactiveEmployeDto);
            throw new InvalidEntityException("Employe non valide", ErrorCodes.EMPLOYE_NOT_VALID,errors);
        }
        inactiveEmployeDto.setDesactive(true);
        return InactiveEmployeDto.fromEntity(inactiveEmployeRepo.save(InactiveEmployeDto.toEntity(inactiveEmployeDto)));
    }

    @Override
    public InactiveEmployeDto findById(Integer id) {
        if(id == null){
            log.error("Employe non valide");
            return null;
        }
        Optional<InactiveEmploye> employe = inactiveEmployeRepo.findById(id);
        return Optional.of(InactiveEmployeDto.fromEntity(employe.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun employe est trouve avec l'id "+id+" dans la base de donnees",ErrorCodes.EMPLOYE_NOT_FOUND));

    }

    @Override
    public List<InactiveEmployeDto> findAll() {
        return inactiveEmployeRepo.findAll().stream()
                .map(InactiveEmployeDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Employe pas valide");
        }
        inactiveEmployeRepo.deleteById(id);

    }
}
