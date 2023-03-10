package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Usuario;
import com.metaenlace.CitasMedicas.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listadoUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuByid(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUsuById(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void saveUsu(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
