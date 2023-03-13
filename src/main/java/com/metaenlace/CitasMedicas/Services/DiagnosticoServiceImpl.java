package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.DiagnosticoDTO;
import com.metaenlace.CitasMedicas.Entities.Diagnostico;
import com.metaenlace.CitasMedicas.Repositories.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService{

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DiagnosticoDTO> listadoDiagnosticos() {
        List<Diagnostico> diagnosticos = diagnosticoRepository.findAll();
        return diagnosticos.stream().map(diagnostico -> new DiagnosticoDTO(diagnostico.getId(), diagnostico.getValoracionEspecialista(), diagnostico.getEnfermedad())).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DiagnosticoDTO findDiagById(long id) {
        Optional<Diagnostico> diag = diagnosticoRepository.findById(id);
        return diag.map(diagnostico -> new DiagnosticoDTO(diagnostico.getId(), diagnostico.getValoracionEspecialista(), diagnostico.getEnfermedad())).orElse(null);
    }

    @Override
    @Transactional
    public void deleteDiag(long id) {
        diagnosticoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveDiag(DiagnosticoDTO diag)
    {
        diagnosticoRepository.save(diag);
    }
}
