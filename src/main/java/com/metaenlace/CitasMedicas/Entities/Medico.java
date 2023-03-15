package com.metaenlace.CitasMedicas.Entities;

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

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Cita> citas;

    @JoinTable(name="medico_pacientes",
            joinColumns = {@JoinColumn(name="medico_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="paciente_id", referencedColumnName = "id")})
    @ManyToMany

    private List<Paciente> pacientes;
}
