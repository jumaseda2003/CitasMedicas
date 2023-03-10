package com.metaenlace.CitasMedicas.Controllers;

import com.metaenlace.CitasMedicas.DTO.DiagnosticoDTO;
import com.metaenlace.CitasMedicas.Entities.Diagnostico;
import com.metaenlace.CitasMedicas.Services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    public DiagnosticoService diagnosticoService;

    @GetMapping("/all")
    public List<DiagnosticoDTO> listadoDiagnosticos() {
        List<Diagnostico> diagnosticos = diagnosticoService.listadoDiagnosticos();
        List<DiagnosticoDTO> diagnosticosDTO = new ArrayList<>();

        for (Diagnostico diagnostico : diagnosticos) {
            diagnosticosDTO.add(new DiagnosticoDTO(diagnostico.getId(), diagnostico.getValoracionEspecialista(), diagnostico.getEnfermedad()));
        }
        return diagnosticosDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosticoDTO> findDiagById(@PathVariable(value = "id") Long id) {
        Optional<Diagnostico> diagnosticos = Optional.ofNullable(diagnosticoService.findDiagById(id));

        if (diagnosticos.isPresent()) {
            Diagnostico diag = diagnosticos.get();
            DiagnosticoDTO diagnosticoDTO = new DiagnosticoDTO(diag.getId(), diag.getValoracionEspecialista(), diag.getEnfermedad());
            return ResponseEntity.ok().body(diagnosticoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/save/{id}")
    public void saveDiag(@RequestBody Diagnostico diag) { diagnosticoService.saveDiag(diag); }

    @DeleteMapping("/delete/{id}")
    public void deleteDiag(@PathVariable long id) { diagnosticoService.deleteDiagById(id);}
}

