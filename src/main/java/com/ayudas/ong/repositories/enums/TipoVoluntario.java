package com.ayudas.ong.repositories.enums;

import java.util.Arrays;

public enum TipoVoluntario {
    SANITARIO,
    ADMINISTRATIVO;

    public static boolean exists(String tipo) {
        return Arrays.stream(TipoVoluntario.values())
                .anyMatch(cuenta -> cuenta.name().equalsIgnoreCase(tipo));
    }
}
