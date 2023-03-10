package com.metaenlace.CitasMedicas.Controllers;

import com.metaenlace.CitasMedicas.Entities.Cita;
import com.metaenlace.CitasMedicas.Services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping("/all")
    public List<Cita> listadoCitas(){ return citaService.listadoCitas();}
    @GetMapping("/{id}")
    public Optional<Cita> findCitaById(@PathVariable long id){ return citaService.findCitaById(id);}
    @PostMapping("/all")
    public Cita saveCita(@RequestBody Cita cita) { return citaService.saveCita(cita);}
    @DeleteMapping("/all")
    public void deleteCita(@RequestBody long id) {
        citaService.deleteCita(id);
    }
}
