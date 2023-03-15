package com.metaenlace.CitasMedicas.Controllers;

import com.metaenlace.CitasMedicas.DTO.CitaDTO;
import com.metaenlace.CitasMedicas.Entities.Cita;
import com.metaenlace.CitasMedicas.Services.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping("/all")
    public List<CitaDTO> listadoCitas(){
        return citaService.listadoCitas();
    }
    @GetMapping("/{id}")
    public CitaDTO findCitaById(@PathVariable long id){
        return citaService.findCitaById(id);
    }
    @PostMapping("/save")
    public CitaDTO saveCita(@RequestBody Cita cita) {
        return citaService.saveCita(cita);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCita(@PathVariable long id) {
        citaService.deleteCita(id);
    }
}
