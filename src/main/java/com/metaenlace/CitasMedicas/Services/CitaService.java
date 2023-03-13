package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.CitaDTO;
import com.metaenlace.CitasMedicas.Entities.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaService {
    List<CitaDTO> listadoCitas();

    /*
    List<Cita> listadoPorFechaHora(Date fh);
    */
    CitaDTO findCitaById(long id);
    void deleteCita(long id);
    void saveCita(CitaDTO cita);
}
