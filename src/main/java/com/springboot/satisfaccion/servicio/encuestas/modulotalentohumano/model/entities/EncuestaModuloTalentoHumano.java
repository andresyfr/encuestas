package com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.model.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Document(collection = "EncuestaModuloTalentoHumano")
@Data
public class EncuestaModuloTalentoHumano
{
    @Id
    @Column(name = "id_ciudadano")
    private long idCiudadano;

    @Column(name = "pregunta_1_a")
    private String pregunta1a;
    @Column(name = "respuesta_1_a")
    private int respuesta1a;

    @Column(name = "pregunta_1_b")
    private String pregunta1b;
    @Column(name = "respuesta_1_b")
    private int respuesta1b;

    @Column(name = "pregunta_1_c")
    private String pregunta1c;
    @Column(name = "respuesta_1_c")
    private int respuesta1c;

    @Column(name = "fecha_diligenciada")
    private String fechaDiligenciada;
}
