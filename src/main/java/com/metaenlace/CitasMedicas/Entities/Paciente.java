package com.metaenlace.CitasMedicas.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="paciente")
@AllArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Paciente extends Usuario {

    @Column(name = "NSS", nullable = false, unique = true)
    private String NSS;

    @Column(name = "numTarjeta", nullable = false, unique = false)
    private String numTarjeta;
    @Column(name = "Telefono", nullable = false, unique = true)
    private String telefono;
    @Column(name = "Direccion", nullable = false, unique = false)
    private String direccion;
    /*
    @OneToMany(mappedBy = "id")
    private List<Cita> citas;

    @OneToMany(mappedBy = "id")
    private List<Medico> medicos;*/
}
