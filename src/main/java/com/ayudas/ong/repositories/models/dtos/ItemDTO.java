package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ItemDTO implements Serializable {

    private EnvioDTO envio;

    private AyudaDTO item;

    private long cantidad;
    
}
