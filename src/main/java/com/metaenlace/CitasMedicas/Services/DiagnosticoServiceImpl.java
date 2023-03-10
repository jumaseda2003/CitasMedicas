package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Diagnostico;
import com.metaenlace.CitasMedicas.Repositories.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService{

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Diagnostico> listadoDiagnosticos() {
        return diagnosticoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Diagnostico findDiagById(long id) {
        Optional<Diagnostico> diag = diagnosticoRepository.findById(id);
        return diag.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteDiagById(long idDiag) {
        diagnosticoRepository.deleteById(idDiag);
    }

    @Override
    @Transactional(readOnly = true)
    public void saveDiag(Diagnostico diag)
    {
        diagnosticoRepository.save(diag);
    }
}
