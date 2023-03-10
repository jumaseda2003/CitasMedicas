package com.metaenlace.CitasMedicas.DTO;

import com.metaenlace.CitasMedicas.Entities.Diagnostico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {
    private long id;
    private LocalDate fechaHora;
    private String motivoCita;
    private int attribute11;
    private Diagnostico diagnostico;
}
