package com.metaenlace.CitasMedicas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticoDTO {
    private long id;
    private String valoracionEspecialista;
    private String enfermedad;
    private CitaCortaDTO cita;
}
