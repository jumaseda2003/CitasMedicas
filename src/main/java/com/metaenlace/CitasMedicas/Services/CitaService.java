package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaService {
    List<Cita> listadoCitas();

    /*
    List<Cita> listadoPorFechaHora(Date fh);
    */
    Optional<Cita> findCitaById(long id);
    void deleteCita(long id);
    Cita saveCita(Cita cita);
}
