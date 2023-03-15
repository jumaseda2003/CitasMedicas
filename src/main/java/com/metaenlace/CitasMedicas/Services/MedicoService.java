package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.MedicoDTO;
import com.metaenlace.CitasMedicas.Entities.Medico;

import java.util.List;

public interface MedicoService {
    List<MedicoDTO> listadoMedicos();
    MedicoDTO findMedById(long id);
    void deleteMedById(long id);
    MedicoDTO saveMed(Medico med);
}
