package com.metaenlace.CitasMedicas.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "usuario")
public class Usuario {
    @Column(name = "id", nullable = false, unique = true )
    @Id
    @SequenceGenerator(name = "id_user", sequenceName = "id_user", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_user")
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(name = "usuario", nullable = false)
    private String usuario;
    @Column(name = "clave", nullable = false)
    private String clave;

    public Usuario(String nombre, String apellidos, String usuario, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
    }
}
