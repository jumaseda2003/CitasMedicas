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
    private long id;
    @Column(name = "fecha", nullable = false, unique = true)
    private LocalDate fecha;

    @Column(name = "motivoCita", nullable = false)
    private String motivoCita;

    @Column(name = "attribute11", nullable = false)
    private int attribute11;


    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
    private Diagnostico diagnostico;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
}
