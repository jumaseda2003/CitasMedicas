package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.MedicoDTO;
import com.metaenlace.CitasMedicas.Entities.Medico;
import com.metaenlace.CitasMedicas.Repositories.MedicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    private final ModelMapper mapper = new ModelMapper();

    private MedicoDTO convertDTO(Medico obj){
        return mapper.map(obj, MedicoDTO.class);
    }
    @Override
    @Transactional(readOnly = true)
    public List<MedicoDTO> listadoMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        List<MedicoDTO> medicoDTOList = new LinkedList<>();
        for (Medico med: medicos){
            medicoDTOList.add(convertDTO(med));
        }
        return medicoDTOList;
    }

    @Override
    @Transactional(readOnly = true)
    public MedicoDTO findMedById(long id) {
        Medico med = medicoRepository.findById(id).orElse(null);
        if (med == null) {
            throw new RuntimeException("Medico no encontrado");
        } else {
            return convertDTO(med);
        }
    }

    @Override
    @Transactional
    public void deleteMedById(long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Médico no encontrado");
        }
    }

    @Override
    public MedicoDTO saveMed(Medico med) {
        medicoRepository.save(med);
        return convertDTO(med);
    }
}
