package com.springboot.satisfaccion.servicio.encuestas.moduloadministracion.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;

@Data
@AllArgsConstructor
public class EncuestaGeneral
{
    @Id
    private long idCiudadano;

    private String pregunta;
    private int respuesta;

    private String fechaDiligenciada;

    public EncuestaGeneral() {}
}
