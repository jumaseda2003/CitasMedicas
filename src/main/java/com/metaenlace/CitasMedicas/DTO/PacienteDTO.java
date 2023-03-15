package com.metaenlace.CitasMedicas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO extends UsuarioDTO {
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
    private List<CitaCortaDTO> citas;
    private List<MedicoCortoDTO> medicos;
}
