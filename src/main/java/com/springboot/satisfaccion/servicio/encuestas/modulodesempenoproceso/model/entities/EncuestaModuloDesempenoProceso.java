package com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.model.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Document(collection = "EncuestaModuloDesempenoProceso")
@Data
public class EncuestaModuloDesempenoProceso
{
    @Id
    @Column(name = "id_ciudadano")
    private long idCiudadano;

    @Column(name = "pregunta_1")
    private String pregunta1;
    @Column(name = "respuesta_1")
    private int respuesta1;

    @Column(name = "pregunta_2_a")
    private String pregunta2a;
    @Column(name = "respuesta_2_a")
    private int respuesta2a;

    @Column(name = "pregunta_2_b")
    private String pregunta2b;
    @Column(name = "respuesta_2_b")
    private int respuesta2b;

    @Column(name = "fecha_diligenciada")
    private String fechaDiligenciada;
}
