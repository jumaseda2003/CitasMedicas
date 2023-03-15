package com.metaenlace.CitasMedicas;

import com.metaenlace.CitasMedicas.Entities.Cita;
import com.metaenlace.CitasMedicas.Entities.Medico;
import com.metaenlace.CitasMedicas.Entities.Paciente;
import com.metaenlace.CitasMedicas.Repositories.CitaRepository;
import com.metaenlace.CitasMedicas.Repositories.DiagnosticoRepository;
import com.metaenlace.CitasMedicas.Repositories.MedicoRepository;
import com.metaenlace.CitasMedicas.Repositories.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CitasMedicasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitasMedicasApplication.class, args);
	}

	@Bean

	CommandLineRunner commandLineRunner(CitaRepository citaRepository, DiagnosticoRepository diagnosticoRepository, MedicoRepository mr, PacienteRepository pr){
		return args->{
			Cita cita=new Cita();
			cita.setFecha(LocalDate.now());
			cita.setMotivoCita("operacion");
			cita.setAttribute11(111);
			citaRepository.save(cita);

			Medico medico = new Medico();
			medico.setNumColegiado("1");
			medico.setNombre("Javier");
			medico.setApellidos("Martinez");
			medico.setUsuario("javi");
			medico.setClave("1234");
			mr.save(medico);

			Paciente paciente = new Paciente();
			paciente.setNSS("3011111111");
			paciente.setDireccion("Calle Prueba");
			paciente.setTelefono("666666666");
			paciente.setNumTarjeta("123456789");
			paciente.setNombre("Pepe");
			paciente.setApellidos("Perez");
			paciente.setUsuario("pepito");
			paciente.setClave("1234");
			pr.save(paciente);
		};
	}
}
