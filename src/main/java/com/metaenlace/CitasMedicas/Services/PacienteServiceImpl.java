package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.PacienteDTO;
import com.metaenlace.CitasMedicas.Entities.Paciente;
import com.metaenlace.CitasMedicas.Repositories.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;

    private final ModelMapper mapper = new ModelMapper();

    private PacienteDTO convertDTO(Paciente pac) {
        return mapper.map(pac, PacienteDTO.class);
    }
    @Override
    @Transactional(readOnly = true)
    public List<PacienteDTO> listadoPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDTO> pacienteDTOList = new LinkedList<>();
        for (Paciente pac: pacientes) {
            pacienteDTOList.add(convertDTO(pac));
        }
        return pacienteDTOList;
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteDTO findPacById(long id) {
        Paciente pac = pacienteRepository.findById(id).orElse(null);
        if (pac == null) {
            throw new RuntimeException("Paciente no encontrado");
        } else {
            return convertDTO(pac);
        }
    }

    @Override
    @Transactional
    public void deletePacById(long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO savePacById(Paciente pac) {
        pacienteRepository.save(pac);
        return convertDTO(pac);
    }
}