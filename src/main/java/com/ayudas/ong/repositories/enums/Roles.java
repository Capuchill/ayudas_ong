package com.ayudas.ong.repositories.enums;

import java.util.Arrays;

public enum Roles {
    ADMIN,
    DIRECTOR,
    ASSISTANT;

    public static boolean exists(String value) {
        return Arrays.stream(Roles.values())
                .anyMatch(role -> role.name().equalsIgnoreCase(value));
    }

}
