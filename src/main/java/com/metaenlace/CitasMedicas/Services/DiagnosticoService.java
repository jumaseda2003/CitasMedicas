package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Diagnostico;

import java.util.List;

public interface DiagnosticoService {
    List<Diagnostico> listadoDiagnosticos();
    Diagnostico findDiagById(long id);
    void deleteDiagById(long id);
    void saveDiag(Diagnostico diag);
}
