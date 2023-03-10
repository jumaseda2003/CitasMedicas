package com.metaenlace.CitasMedicas.Controllers;

import com.metaenlace.CitasMedicas.Entities.Medico;
import com.metaenlace.CitasMedicas.Services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService ms;
    @GetMapping("/all")
    public List<Medico> listadoMedicos() { return ms.listadoMedicos(); }
    @GetMapping("/{id}")
    public Optional<Medico> findMedById(@PathVariable long id) { return ms.findMedById(id); }

    @DeleteMapping("/{id}/delete")
    public void deleteMedico(@PathVariable long id) { ms.deleteMedById(id); }

    @PostMapping("/{id}/save")
    public void saveMedico(Medico med){ ms.saveMed(med); }
}
