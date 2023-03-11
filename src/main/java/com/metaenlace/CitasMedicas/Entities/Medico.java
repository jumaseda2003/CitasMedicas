package com.metaenlace.CitasMedicas.Entities;

import com.metaenlace.CitasMedicas.Repositories.PacienteRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "medico")
@NoArgsConstructor
@AllArgsConstructor

@PrimaryKeyJoinColumn(referencedColumnName = "id")

public class Medico extends Usuario{
    @Column(name = "numColegiado", nullable = false, unique = true)
    private String numColegiado;
/*
    @OneToMany(mappedBy = "id")
    @ElementCollection
    private List<Cita> citas;

    @ManyToMany(mappedBy = "id")
    private List<Paciente> pacientes;*/
    @ManyToMany
    private List<Paciente> pacientes;
}
