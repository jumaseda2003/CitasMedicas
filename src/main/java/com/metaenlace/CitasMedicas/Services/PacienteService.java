package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.PacienteDTO;
import com.metaenlace.CitasMedicas.Entities.Paciente;

import java.util.List;

public interface PacienteService {
    List<PacienteDTO> listadoPacientes();
    PacienteDTO findPacById(long id);
    void deletePacById(long id);
    void savePacById(PacienteDTO pac);
}
