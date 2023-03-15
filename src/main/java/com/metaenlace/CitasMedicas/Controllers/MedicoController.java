package com.metaenlace.CitasMedicas.Controllers;


import com.metaenlace.CitasMedicas.DTO.MedicoDTO;
import com.metaenlace.CitasMedicas.Entities.Medico;
import com.metaenlace.CitasMedicas.Services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService ms;
    @GetMapping("/all")
    public List<MedicoDTO> listadoMedicos() {
        return ms.listadoMedicos();
    }
    @GetMapping("/{id}")
    public MedicoDTO findMedById(@PathVariable long id) { return ms.findMedById(id); }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable long id) { ms.deleteMedById(id); }

    @PostMapping("/save")
    public MedicoDTO saveMedico(Medico med){ return ms.saveMed(med); }
}
