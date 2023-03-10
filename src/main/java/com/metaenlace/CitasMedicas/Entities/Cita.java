package com.metaenlace.CitasMedicas.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "cita")
@AllArgsConstructor
@NoArgsConstructor
public class Cita {
    @Column(name = "id", nullable = false, unique = true)
    @Id
    @SequenceGenerator(name = "citaSecuencia", sequenceName = "citaSecuencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citaSecuencia")
    private long id;
    @Column(name = "fechaHora", nullable = false, unique = true)
    private LocalDate fechaHora;

    @Column(name = "motivoCita", nullable = false, unique = false)
    private String motivoCita;

    @Column(name = "attribute11", nullable = false, unique = false)
    private int attribute11;


    @OneToOne(optional = true, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
    private Diagnostico diagnostico;

    /*@OneToOne
    private Paciente paciente;

    @OneToOne
    private Medico medico;*/
}
