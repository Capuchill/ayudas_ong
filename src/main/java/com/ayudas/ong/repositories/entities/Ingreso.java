package com.ayudas.ong.repositories.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.ayudas.ong.repositories.enums.TiposCuenta;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Ingresos")
public class Ingreso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @ManyToOne
    @JoinColumn(
        name = "socio_id"
    )
    private Socio socio;

    @Enumerated(EnumType.STRING)
    private TiposCuenta tipoCuenta;

    private double cuota;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaPago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public TiposCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TiposCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = this.tipoCuenta.getCuota();
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo() {
        this.codigo = String.valueOf(this.fechaPago.getDayOfYear()) + String.valueOf(this.socio.getCedula()) + String.valueOf(this.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((socio == null) ? 0 : socio.hashCode());
        result = prime * result + ((tipoCuenta == null) ? 0 : tipoCuenta.hashCode());
        long temp;
        temp = Double.doubleToLongBits(cuota);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((fechaPago == null) ? 0 : fechaPago.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ingreso other = (Ingreso) obj;
        if (socio == null) {
            if (other.socio != null)
                return false;
        } else if (!socio.equals(other.socio))
            return false;
        if (tipoCuenta != other.tipoCuenta)
            return false;
        if (Double.doubleToLongBits(cuota) != Double.doubleToLongBits(other.cuota))
            return false;
        if (fechaPago == null) {
            if (other.fechaPago != null)
                return false;
        } else if (!fechaPago.equals(other.fechaPago))
            return false;
        return true;
    }
}
