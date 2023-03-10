package com.metaenlace.CitasMedicas.Controllers;

import com.metaenlace.CitasMedicas.DTO.MedicoDTO;
import com.metaenlace.CitasMedicas.Entities.Medico;
import com.metaenlace.CitasMedicas.Services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService ms;
    @GetMapping("/all")
    public List<MedicoDTO> listadoMedicos() {
        List<Medico> medicos = ms.listadoMedicos();
        List<MedicoDTO> medicosDTO = new ArrayList<>();
        for (Medico medico : medicos){
            medicosDTO.add(new MedicoDTO(medico.getNumColegiado()));
        }
        return medicosDTO;
    }
    @GetMapping("/{id}")
    public Optional<Medico> findMedById(@PathVariable long id) { return ms.findMedById(id); }

    @DeleteMapping("/{id}/delete")
    public void deleteMedico(@PathVariable long id) { ms.deleteMedById(id); }

    @PostMapping("/{id}/save")
    public void saveMedico(Medico med){ ms.saveMed(med); }
}
