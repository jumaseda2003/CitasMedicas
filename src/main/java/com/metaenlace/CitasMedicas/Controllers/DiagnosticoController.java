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
        return diagnosticoService.listadoDiagnosticos();
    }

    @GetMapping("/{id}")
    public DiagnosticoDTO findDiagById(@PathVariable(value = "id") Long id) {
        return diagnosticoService.findDiagById(id);
    }


    @PostMapping("/save/{id}")
    public void saveDiag(@RequestBody DiagnosticoDTO diag) {
        diagnosticoService.saveDiag(diag);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteDiag(@PathVariable long id) { diagnosticoService.deleteDiag(id);}
}

