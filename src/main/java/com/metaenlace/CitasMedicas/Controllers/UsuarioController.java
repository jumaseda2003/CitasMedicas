package com.metaenlace.CitasMedicas.Controllers;

import com.metaenlace.CitasMedicas.DTO.UsuarioDTO;
import com.metaenlace.CitasMedicas.Entities.Usuario;
import com.metaenlace.CitasMedicas.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService UsuService;

    @GetMapping("/all")
    public List<UsuarioDTO> listadoUsuarios(){
        return UsuService.listadoUsuarios();
    }
    @GetMapping("/{id}")
    public UsuarioDTO findUsuById (@PathVariable long id){
        return UsuService.findUsuByid(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUsuById (@PathVariable long id) { UsuService.deleteUsuById(id);}
    @PostMapping("/save")
    public UsuarioDTO saveUser(@RequestBody Usuario usu) {
        return UsuService.saveUsu(usu);
    }
}



