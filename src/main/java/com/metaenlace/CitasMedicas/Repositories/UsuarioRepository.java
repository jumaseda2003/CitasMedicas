package com.metaenlace.CitasMedicas.Repositories;

import com.metaenlace.CitasMedicas.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
