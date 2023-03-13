package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.UsuarioDTO;
import com.metaenlace.CitasMedicas.Entities.Usuario;
import com.metaenlace.CitasMedicas.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> listadoUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getUsuario(), usuario.getClave(), usuario.getNombre(), usuario.getApellidos())).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO findUsuByid(long id) {
        Optional<Usuario> usu = usuarioRepository.findById(id);
        return usu.map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getUsuario(), usuario.getClave(), usuario.getNombre(), usuario.getApellidos())).orElse(null);
    }

    @Override
    @Transactional
    public void deleteUsuById(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveUsu(UsuarioDTO usuario) {
        usuarioRepository.save(usuario);
    }
}
