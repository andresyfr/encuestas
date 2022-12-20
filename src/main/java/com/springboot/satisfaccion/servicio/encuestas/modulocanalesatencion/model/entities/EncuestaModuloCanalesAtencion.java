package com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.model.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Document(collection = "EncuestaModuloCanalesAtencion")
@Data
public class EncuestaModuloCanalesAtencion {
    @Id
    @Column(name = "id_ciudadano")
    private long idCiudadano;

    @Column(name = "pregunta_1")
    private String pregunta1;
    @Column(name = "respuesta_1")
    private int respuesta1;

    @Column(name = "pregunta_2")
    private String pregunta2;
    @Column(name = "respuesta_2")
    private int respuesta2;

    @Column(name = "fecha_diligenciada")
    private String fechaDiligenciada;
}
