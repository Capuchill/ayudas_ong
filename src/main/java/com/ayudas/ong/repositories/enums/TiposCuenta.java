package com.ayudas.ong.repositories.enums;

import java.util.Arrays;

public enum TiposCuenta {
    MINIMA(10),
    MEDIA(20),
    MAXIMA(30);

    private double cuota;

    private TiposCuenta(double cuota) {
        this.cuota = cuota;
    }

    public double getCuota() {
        return cuota;
    }

    public static boolean exists(String tipo) {
        return Arrays.stream(TiposCuenta.values())
                .anyMatch(cuenta -> cuenta.name().equalsIgnoreCase(tipo));
    }
}
