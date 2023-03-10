package com.metaenlace.CitasMedicas.Repositories;

import com.metaenlace.CitasMedicas.Entities.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
}
