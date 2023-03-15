package com.metaenlace.CitasMedicas.Controllers;

import com.metaenlace.CitasMedicas.DTO.PacienteDTO;
import com.metaenlace.CitasMedicas.Entities.Paciente;
import com.metaenlace.CitasMedicas.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/all")
    public List<PacienteDTO> listadoPacientes() {
        return pacienteService.listadoPacientes();
    }

    @GetMapping("/{idPac}")
    public PacienteDTO findPacById(@PathVariable long idPac) {
        return pacienteService.findPacById(idPac);
    }

    @DeleteMapping("/{idPac}")
    public void deletePacById(@PathVariable long idPac) {
        pacienteService.deletePacById(idPac);
    }

    @PostMapping("/save")
    public PacienteDTO savePacById(@RequestBody Paciente pac) {
        return pacienteService.savePacById(pac);
    }
}