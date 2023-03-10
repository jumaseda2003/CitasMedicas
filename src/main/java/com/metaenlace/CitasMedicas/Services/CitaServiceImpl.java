package com.metaenlace.CitasMedicas.Services;

import com.metaenlace.CitasMedicas.Entities.Cita;
import com.metaenlace.CitasMedicas.Repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService{
    @Autowired
    private CitaRepository citaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> listadoCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Optional<Cita> findCitaById(long id) {
        return citaRepository.findById(id);
    }

    /*
    @Override
    @Transactional(readOnly = true)
    public List<Cita> listadoPorFechaHora(Date fh) {
        return citaRepository.findbyFechaHora(fh);
    }
    */
    @Override
    @Transactional(readOnly = true)
    public void deleteCita(long id) {
        citaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cita saveCita(Cita cita) {
        citaRepository.save(cita);
        return cita;
    }
}
