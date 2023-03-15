package com.metaenlace.CitasMedicas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticoCortoDTO {
    private Long id;
    private String valoracionEspecialista;
    private String enfermedad;
}
