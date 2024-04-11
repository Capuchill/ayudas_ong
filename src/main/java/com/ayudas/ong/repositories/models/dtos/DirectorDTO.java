package com.ayudas.ong.repositories.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DirectorDTO extends PersonaDTO {

    private SedeDTO sede;

}
