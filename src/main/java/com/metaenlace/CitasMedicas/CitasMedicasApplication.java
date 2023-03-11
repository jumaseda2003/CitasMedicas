package com.metaenlace.CitasMedicas;

import com.metaenlace.CitasMedicas.Entities.Cita;
import com.metaenlace.CitasMedicas.Entities.Diagnostico;

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
import java.util.Optional;

@SpringBootApplication
public class CitasMedicasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitasMedicasApplication.class, args);
	}

	@Bean

	CommandLineRunner commandLineRunner(CitaRepository citaRepository, DiagnosticoRepository diagnosticoRepository, MedicoRepository mr, PacienteRepository pr){
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

			Medico medico = new Medico();
			medico.setNumColegiado("1");
			medico.setNombre("Javier");
			medico.setApellidos("Martinez");
			medico.setUsuario("javi");
			medico.setClave("1234");
			mr.save(medico);
			Medico medico1 = mr.findMedById(1);
			System.out.println(medico1.toString());

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
