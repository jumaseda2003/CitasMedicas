package com.metaenlace.CitasMedicas;

import com.metaenlace.CitasMedicas.Entities.Cita;
import com.metaenlace.CitasMedicas.Entities.Diagnostico;
import com.metaenlace.CitasMedicas.Repositories.CitaRepository;
import com.metaenlace.CitasMedicas.Repositories.DiagnosticoRepository;
import com.metaenlace.CitasMedicas.Services.CitaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class CitasMedicasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitasMedicasApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CitaRepository citaRepository, DiagnosticoRepository diagnosticoRepository){
		return args->{
			Cita cita=new Cita();
			cita.setFechaHora(LocalDate.now());
			cita.setMotivoCita("operacion");
			cita.setAttribute11(111);
			Diagnostico dia=new Diagnostico();
			dia.setValoracionEspecialista("leve");
			dia.setEnfermedad("fiebre");
			cita.setDiagnostico(dia);
			diagnosticoRepository.save(dia);
			citaRepository.save(cita);
			Cita cita2 = citaRepository.findCitaById(1l);
			System.out.println(cita2.toString());
		};

	}

}
