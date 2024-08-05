package com.app.sonatrach.dto;

import com.app.sonatrach.model.Employe;
import com.app.sonatrach.model.MotifDepart;
import com.app.sonatrach.model.PMT;
import com.app.sonatrach.model.PrevisionDepart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PrevisionDepartDto {
    private Integer id;

    private Instant annee ;

    private MotifDepart motif = MotifDepart.RETRAITE ;

    private String observation ;

    private Boolean isConfirmed = false ;


    private PMTDto pmtDto;


    private EmployeDto employeDto;

    public static PrevisionDepartDto fromEntity(PrevisionDepart previsionDepart) {
        if (previsionDepart == null) {
            return null;
        }
        return PrevisionDepartDto.builder()
                .id(previsionDepart.getId())
                .annee(previsionDepart.getAnnee())
                .motif(previsionDepart.getMotif())
                .observation(previsionDepart.getObservation())
                .isConfirmed(previsionDepart.getIsConfirmed())
                .pmtDto(PMTDto.fromEntity(previsionDepart.getPmt()))
                .employeDto(EmployeDto.fromEntity(previsionDepart.getEmploye()))
                .build();
    }

    public static PrevisionDepart toEntity(PrevisionDepartDto previsionDepartDto){
        if (previsionDepartDto == null) {
            return null;
        }
        PrevisionDepart previsionDepart = new PrevisionDepart();
        previsionDepart.setId(previsionDepartDto.getId());
        previsionDepart.setAnnee(previsionDepartDto.getAnnee());
        previsionDepart.setMotif(previsionDepartDto.getMotif());
        previsionDepart.setObservation(previsionDepartDto.getObservation());
        previsionDepart.setIsConfirmed(previsionDepartDto.getIsConfirmed());
        previsionDepart.setPmt(PMTDto.toEntity(previsionDepartDto.getPmtDto()));
        previsionDepart.setEmploye(EmployeDto.toEntity(previsionDepartDto.getEmployeDto()));
        return previsionDepart;
    }
}
