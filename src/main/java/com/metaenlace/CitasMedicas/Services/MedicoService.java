package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoService {
    List<Medico> listadoMedicos();
    Optional<Medico> findMedById(long id);
    void deleteMedById(long id);
    void saveMed(Medico med);
}
