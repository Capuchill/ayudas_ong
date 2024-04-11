package com.ayudas.ong.repositories.entities;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
public abstract class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long cedula;

    @NotBlank(message = "Primer nombre requerido")
    @NotNull(message = "Primer nombre requerido")
    @NotEmpty(message = "Primer nombre requerido")
    private String p_nombre;

    private String s_nombre;

    @NotBlank(message = "Primer apellido requerido")
    @NotNull(message = "Primer apellido requerido")
    @NotEmpty(message = "Primer apellido requerido")
    private String p_apellido;
    
    private String s_apellido;

    @ManyToOne
    @JoinColumn(
        name = "rol_id"
    )
    private Rol rol;

    @Email(message = "El formato de email no es correcto")
    private String email;

    private String passWord;

    public Persona (long cedula, String p_nombre, String s_nombre, String p_apellido, String s_apellido, Rol rol, String email, String passWord) {
        super();
        this.cedula = cedula;
        this.p_nombre = p_nombre;
        this.s_nombre = s_nombre;
        this.p_apellido = p_apellido;
        this.s_apellido = s_apellido;
        this.rol = rol;
        this.email = email;
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (cedula != other.cedula)
            return false;
        if (p_nombre == null) {
            if (other.p_nombre != null)
                return false;
        } else if (!p_nombre.equals(other.p_nombre))
            return false;
        if (p_apellido == null) {
            if (other.p_apellido != null)
                return false;
        } else if (!p_apellido.equals(other.p_apellido))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (cedula ^ (cedula >>> 32));
        result = prime * result + ((p_nombre == null) ? 0 : p_nombre.hashCode());
        result = prime * result + ((p_apellido == null) ? 0 : p_apellido.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }
    
}
