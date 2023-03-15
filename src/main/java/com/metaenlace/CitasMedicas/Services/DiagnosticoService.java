package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.DiagnosticoDTO;
import com.metaenlace.CitasMedicas.Entities.Diagnostico;

import java.util.List;

public interface DiagnosticoService {
    List<DiagnosticoDTO> listadoDiagnosticos();
    DiagnosticoDTO findDiagById(long id);
    void deleteDiag(long id);
    DiagnosticoDTO saveDiag(Diagnostico diag);
}
