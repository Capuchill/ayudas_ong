package com.ayudas.ong.repositories.enums;

import java.util.Arrays;

public enum Disponibilidad {
    SI,
    NO;

    public static boolean exists(String tipo) {
        return Arrays.stream(Disponibilidad.values())
                .anyMatch(cuenta -> cuenta.name().equalsIgnoreCase(tipo));
    }
}
