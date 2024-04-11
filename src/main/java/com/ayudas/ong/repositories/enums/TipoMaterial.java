package com.ayudas.ong.repositories.enums;

import java.util.Arrays;

public enum TipoMaterial {
    ALIMENTOS,
    MEDICAMENTOS;


    public boolean exists(String tipo) {
        return Arrays.stream(TipoMaterial.values())
                .anyMatch(cuenta -> cuenta.name().equalsIgnoreCase(tipo));
    }
}
