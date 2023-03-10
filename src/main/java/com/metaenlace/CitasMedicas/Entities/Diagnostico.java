package com.metaenlace.CitasMedicas.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="diagnostico")
@AllArgsConstructor
@NoArgsConstructor
public class Diagnostico {

    @Column(name = "id",nullable = false,unique = true)
    @Id
    @SequenceGenerator(name = "diagnosticoSecuencia", sequenceName = "diagnosticoSecuencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diagnosticoSecuencia")
    private long id;
    @Column(name = "valoracionEspecialista", nullable = false, unique = true)
    private String valoracionEspecialista;

    @Column(name = "enfermedad", nullable = false, unique = false)
    private String enfermedad;
    /*
    @OneToOne
    private Cita cita;*/
}
