package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.MedicoDTO;
import com.metaenlace.CitasMedicas.Entities.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoService {
    List<MedicoDTO> listadoMedicos();
    MedicoDTO findMedById(long id);
    void deleteMedById(long id);
    void saveMed(MedicoDTO med);
}
