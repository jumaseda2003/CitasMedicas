package com.metaenlace.CitasMedicas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO extends UsuarioDTO {
    private String numColegiado;
    private List<PacienteDTO> pacientes;
}
