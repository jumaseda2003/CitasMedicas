package com.metaenlace.CitasMedicas.Controllers;

import com.metaenlace.CitasMedicas.Entities.Paciente;
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
    public List<Usuario> listadoUsuarios(){
        return UsuService.listadoUsuarios();
    }
    @GetMapping("/{id}")
    public Usuario findUsuById (@PathVariable long id){
        return UsuService.findUsuByid(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUsuById (@PathVariable long id) { UsuService.deleteUsuById(id);}
    @PostMapping("/save")
    public void saveUser(@RequestBody Usuario usu) {
        UsuService.saveUsu(usu);
    }
}



