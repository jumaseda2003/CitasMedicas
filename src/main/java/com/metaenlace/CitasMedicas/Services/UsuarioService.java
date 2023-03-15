package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.UsuarioDTO;
import com.metaenlace.CitasMedicas.Entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listadoUsuarios();

    UsuarioDTO findUsuByid(long id);

    void deleteUsuById(long id);
    UsuarioDTO saveUsu(Usuario usu);
}

