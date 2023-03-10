package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listadoUsuarios();

    Usuario findUsuByid(long id);

    void deleteUsuById(long id);
    void saveUsu(Usuario usu);
}

