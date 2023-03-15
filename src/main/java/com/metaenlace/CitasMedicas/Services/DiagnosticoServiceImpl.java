package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.DiagnosticoDTO;
import com.metaenlace.CitasMedicas.Entities.Diagnostico;
import com.metaenlace.CitasMedicas.Repositories.DiagnosticoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService{

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    private final ModelMapper mapper = new ModelMapper();

    private DiagnosticoDTO convertDTO(Diagnostico diag){
        return mapper.map(diag, DiagnosticoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiagnosticoDTO> listadoDiagnosticos() {
        List<Diagnostico> diagnosticos = diagnosticoRepository.findAll();
        List<DiagnosticoDTO> diagnosticoDTOList = new LinkedList<>();
        for (Diagnostico diag: diagnosticos) {
            diagnosticoDTOList.add(convertDTO(diag));
        }
        return diagnosticoDTOList;
    }

    @Override
    @Transactional(readOnly = true)
    public DiagnosticoDTO findDiagById(long id) {
        Diagnostico diag = diagnosticoRepository.findById(id).orElse(null);
        if (diag == null) {
            throw new RuntimeException("Diagnostico no encontrado");
        } else {
            return convertDTO(diag);
        }
    }

    @Override
    @Transactional
    public void deleteDiag(long id) {
        if (diagnosticoRepository.existsById(id)) {
            diagnosticoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Diagnostico no encontrado");
        }

    }

    @Override
    public DiagnosticoDTO saveDiag(Diagnostico diag)
    {
        diagnosticoRepository.save(diag);
        return convertDTO(diag);
    }
}
