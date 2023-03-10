package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> listadoPacientes();
    Paciente findPacById(long idPac);
    void deletePacById(long idPac);
    void savePacById(Paciente pac);
}
