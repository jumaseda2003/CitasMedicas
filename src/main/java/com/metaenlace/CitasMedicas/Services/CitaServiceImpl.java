package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.CitaDTO;
import com.metaenlace.CitasMedicas.Entities.Cita;
import com.metaenlace.CitasMedicas.Repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitaServiceImpl implements CitaService{
    @Autowired
    private CitaRepository citaRepository;
    private final ModelMapper mapper = new ModelMapper();

    private CitaDTO mapToDTO(Cita obj){
        CitaDTO dto = mapper.map(obj, CitaDTO.class);
        return dto;
    }
    private CitaDTO mapToEntity(CitaDTO obj){
        CitaDTO dto = mapper.map(obj, CitaDTO.class);
        return dto;
    }


    @Override
    @Transactional(readOnly = true)
    public List<CitaDTO> listadoCitas() {
        List<Cita> citas = citaRepository.findAll();
        return citas.stream().map(cita -> new CitaDTO(cita.getId(), cita.getFechaHora(), cita.getMotivoCita(), cita.getAttribute11(), cita.getDiagnostico())).collect(Collectors.toList());
    }

    @Override
    public CitaDTO findCitaById(long id) {
        Optional<Cita> citaPorId = citaRepository.findById(id);
        return citaPorId.map(cita -> new CitaDTO(cita.getId(),cita.getFechaHora(), cita.getMotivoCita(), cita.getAttribute11(), cita.getDiagnostico())).orElse(null);
    }

    /*
    @Override
    @Transactional(readOnly = true)
    public List<Cita> listadoPorFechaHora(Date fh) {
        return citaRepository.findbyFechaHora(fh);
    }
    */
    @Override
    @Transactional
    public void deleteCita(long id) {
        citaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveCita(CitaDTO cita) {
        citaRepository.save(mapToEntity(cita));
    }
}
