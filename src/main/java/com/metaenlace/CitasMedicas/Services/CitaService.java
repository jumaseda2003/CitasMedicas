package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.CitaDTO;
import com.metaenlace.CitasMedicas.Entities.Cita;

import java.util.List;

public interface CitaService {
    List<CitaDTO> listadoCitas();

    /*
    List<Cita> listadoPorFechaHora(Date fh);
    */
    CitaDTO findCitaById(long id);
    void deleteCita(long id);
    CitaDTO saveCita(Cita cita);
}
