package com.metaenlace.CitasMedicas.Controllers;

import com.metaenlace.CitasMedicas.DTO.DiagnosticoDTO;
import com.metaenlace.CitasMedicas.Entities.Diagnostico;
import com.metaenlace.CitasMedicas.Services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    public DiagnosticoService diagnosticoService;

    @GetMapping("/all")
    public List<DiagnosticoDTO> listadoDiagnosticos() {
        return diagnosticoService.listadoDiagnosticos();
    }

    @GetMapping("/{id}")
    public DiagnosticoDTO findDiagById(@PathVariable(value = "id") Long id) {
        return diagnosticoService.findDiagById(id);
    }


    @PostMapping("/save")
    public DiagnosticoDTO saveDiag(@RequestBody Diagnostico diag) {
        return diagnosticoService.saveDiag(diag);
    }


    @DeleteMapping("/{id}")
    public void deleteDiag(@PathVariable long id) { diagnosticoService.deleteDiag(id);}
}

