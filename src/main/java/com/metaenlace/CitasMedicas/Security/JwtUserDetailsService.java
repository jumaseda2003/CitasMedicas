package com.metaenlace.CitasMedicas.Security;

import com.metaenlace.CitasMedicas.Entities.Usuario;
import com.metaenlace.CitasMedicas.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre de usuario: " + username);
        }
        return new User(usuario.getUsuario(), usuario.getClave(),
                new ArrayList<>());
    }
}

