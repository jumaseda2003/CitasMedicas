package com.metaenlace.CitasMedicas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaCortaDTO {
    private Long id;
    private LocalDate fecha;
    private String motivoCita;
}
