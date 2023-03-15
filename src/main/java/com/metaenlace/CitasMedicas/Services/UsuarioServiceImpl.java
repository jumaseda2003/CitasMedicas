package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.DTO.UsuarioDTO;
import com.metaenlace.CitasMedicas.Entities.Usuario;
import com.metaenlace.CitasMedicas.Repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    private final ModelMapper mapper = new ModelMapper();

    private UsuarioDTO convertDTO(Usuario usu){
        return mapper.map(usu, UsuarioDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> listadoUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOList = new LinkedList<>();
        for (Usuario usu : usuarios){
            usuarioDTOList.add(convertDTO(usu));
        }
        return usuarioDTOList;
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO findUsuByid(long id) {
        Usuario usu = usuarioRepository.findById(id).orElse(null);
        if (usu == null) {
            throw new RuntimeException("Usuario no encontrado");
        } else {
            return convertDTO(usu);
        }
    }

    @Override
    @Transactional
    public void deleteUsuById(long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    @Override
    public UsuarioDTO saveUsu(Usuario usuario) {
        usuarioRepository.save(usuario);
        return convertDTO(usuario);
    }
}
