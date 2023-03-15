package com.metaenlace.CitasMedicas.Entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
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

    @Column(name = "numTarjeta", nullable = false)
    private String numTarjeta;
    @Column(name = "Telefono", nullable = false, unique = true)
    private String telefono;
    @Column(name = "Direccion", nullable = false)
    private String direccion;


    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Cita> citas;

    @ManyToMany(mappedBy = "pacientes")
    private List<Medico> medicos;

    public Paciente(String nombre, String apellidos, String usuario, String clave, String NSS, String numTarjeta, String telefono, String direccion, @Nullable List<Cita> citas, @Nullable List<Medico> medico) {
        super(nombre, apellidos, usuario, clave);
        this.NSS = NSS;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
        this.citas = new ArrayList<>();
        this.medicos = new ArrayList<>();
    }
}
