package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.MedicoDTO;
import com.metaenlace.CitasMedicas.Entities.Medico;
import com.metaenlace.CitasMedicas.Repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Override
    @Transactional(readOnly = true)
    public List<MedicoDTO> listadoMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream().map(medico -> new MedicoDTO(medico.getNumColegiado())).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MedicoDTO findMedById(long id) {
        Optional<Medico> med = medicoRepository.findById(id);
        return med.map(medico -> new MedicoDTO(medico.getNumColegiado())).orElse(null);
    }

    @Override
    @Transactional
    public void deleteMedById(long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveMed(MedicoDTO med) {
        medicoRepository.save(med);
    }
}
