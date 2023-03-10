package com.metaenlace.CitasMedicas.Repositories;

import com.metaenlace.CitasMedicas.Entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    /*
    List<Cita> findbyFechaHora(Date fh);
*/
    Cita findCitaById(long id);
}
