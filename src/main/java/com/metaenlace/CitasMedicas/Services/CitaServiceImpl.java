package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.CitaDTO;
import com.metaenlace.CitasMedicas.Entities.Cita;
import com.metaenlace.CitasMedicas.Repositories.CitaRepository;
import com.metaenlace.CitasMedicas.Repositories.DiagnosticoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService{
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    private final ModelMapper mapper = new ModelMapper();

    private CitaDTO convertDTO(Cita obj){
        CitaDTO dto = mapper.map(obj, CitaDTO.class);
        return dto;
    }


    @Override
    @Transactional(readOnly = true)
    public List<CitaDTO> listadoCitas() {
        List<Cita> citas = citaRepository.findAll();
        List<CitaDTO> citaDTOList = new LinkedList<CitaDTO>();
        for (Cita cita: citas){
            citaDTOList.add(convertDTO(cita));
        }
        return citaDTOList;
    }

    @Override
    public CitaDTO findCitaById(long id) {
       Cita citaPorId = citaRepository.findById(id).orElse(null);
        if (citaPorId == null){
            throw new RuntimeException("Cita no encontrada");
        } else {
            return convertDTO(citaPorId);
        }
    }

    @Override
    @Transactional
    public void deleteCita(long id) {
        if (citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cita no encontrada");
        }
    }

    @Override
    public CitaDTO saveCita(Cita cita) {
        citaRepository.save(cita);
        return convertDTO(cita);
    }
}
