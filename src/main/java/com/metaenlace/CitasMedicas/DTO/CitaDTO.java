package com.metaenlace.CitasMedicas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {
    private long id;
    private LocalDate fecha;
    private String motivoCita;
    private int attribute11;
    private PacienteDTO pacienteDTO;
    private MedicoCortoDTO medicoCortoDTO;
    private DiagnosticoCortoDTO diagnostico;

}
