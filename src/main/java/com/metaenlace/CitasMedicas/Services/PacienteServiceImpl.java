package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.PacienteDTO;
import com.metaenlace.CitasMedicas.Entities.Paciente;
import com.metaenlace.CitasMedicas.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;
    @Override
    @Transactional(readOnly = true)
    public List<PacienteDTO> listadoPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(paciente -> new PacienteDTO(paciente.getNSS(), paciente.getNumTarjeta(), paciente.getTelefono(), paciente.getDireccion())).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteDTO findPacById(long id) {
        Optional<Paciente> pac = pacienteRepository.findById(id);
        return pac.map(paciente -> new PacienteDTO(paciente.getNSS(), paciente.getNumTarjeta(), paciente.getTelefono(), paciente.getDireccion())).orElse(null);
    }

    @Override
    @Transactional
    public void deletePacById(long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void savePacById(PacienteDTO pac) {
        pacienteRepository.save(pac);
    }
}