package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Paciente;
import com.metaenlace.CitasMedicas.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Paciente> listadoPacientes() {
        return (List<Paciente>) pacienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente findPacById(long id) {
        return (Paciente) pacienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public void deletePacById(long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void savePacById(Paciente pac) {
        pacienteRepository.save(pac);
    }
}