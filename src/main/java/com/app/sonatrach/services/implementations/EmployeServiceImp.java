package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.EmployeDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.repositories.EmployeRepo;
import com.app.sonatrach.services.EmployeService;
import com.app.sonatrach.validators.EmployeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.sonatrach.model.Employe;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeServiceImp implements EmployeService {

    private EmployeRepo employeRepo;
    @Autowired
    public EmployeServiceImp(EmployeRepo employeRepo){
        this.employeRepo = employeRepo;
    }

    @Override
    public EmployeDto save(EmployeDto employeDto) {
        List<String> errors = EmployeValidator.validate(employeDto);
        if(!errors.isEmpty()){
            log.error("Employe not valid",employeDto);
            throw new InvalidEntityException("Employe non valide", ErrorCodes.EMPLOYE_NOT_VALID,errors);
        }
        return EmployeDto.fromEntity(employeRepo.save(EmployeDto.toEntity(employeDto)));
    }

    @Override
    public EmployeDto findById(Integer id) {
        if(id == null){
            log.error("Employe pas valide");
            return null;
        }
        Optional<Employe> employe = employeRepo.findById(id);
        return Optional.of(EmployeDto.fromEntity(employe.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun employe est trouve avec l'id "+id+" dans la base de donnees",ErrorCodes.EMPLOYE_NOT_FOUND));
    }

    @Override
    public List<EmployeDto> findAll() {
        return employeRepo.findAll().stream()
                .map(EmployeDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<EmployeDto> findAllActives() {
        // Récupérer tous les employés
        List<Employe> allEmployes = employeRepo.findAll();

        // Filtrer les employés actifs
        List<Employe> activeEmployes = allEmployes.stream()
                .filter(employe -> !employe.getDesactive())
                .collect(Collectors.toList());

        return activeEmployes.stream()
                .map(EmployeDto::fromEntity).collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Employe not valide");
        }
        employeRepo.deleteById(id);
    }
}
