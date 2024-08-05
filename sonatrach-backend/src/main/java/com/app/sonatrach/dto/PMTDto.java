package com.app.sonatrach.dto;

import com.app.sonatrach.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PMTDto {
    private Integer id;

    private Instant aneeDebut ;

    private Integer duration;

    public boolean isCurrentYear() {
        // Obtenir l'année actuelle
        int currentYear = Year.now().getValue();

        // Convertir l'Instant en LocalDateTime en utilisant le fuseau horaire du système
        LocalDateTime localDateTime = LocalDateTime.ofInstant(this.aneeDebut, ZoneId.systemDefault());

        // Obtenir l'année de la date fournie
        int dateYear = localDateTime.getYear();

        // Comparer les années
        return currentYear == dateYear;
    }


    public static PMTDto fromEntity(PMT pmt) {
        if (pmt == null) {
            return null;
        }
        return PMTDto.builder()
                .id(pmt.getId())
                .aneeDebut(pmt.getAneeDebut())
                .duration(pmt.getDuration())
                .build();
    }

    public static PMT toEntity(PMTDto pmtDto){
        if (pmtDto == null) {
            return null;
        }
        PMT pmt = new PMT();
        pmt.setId(pmtDto.getId());
        pmt.setAneeDebut(pmtDto.getAneeDebut());
        pmt.setDuration(pmtDto.getDuration());

        return pmt;
    }
}
