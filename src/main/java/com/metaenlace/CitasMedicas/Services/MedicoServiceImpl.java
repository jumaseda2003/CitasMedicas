package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Medico;
import com.metaenlace.CitasMedicas.Repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Medico> listadoMedicos() {
        return (List<Medico>) medicoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Medico> findMedById(long id) {
        return medicoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteMedById(long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void saveMed(Medico med) {
        medicoRepository.save(med);
    }
}
