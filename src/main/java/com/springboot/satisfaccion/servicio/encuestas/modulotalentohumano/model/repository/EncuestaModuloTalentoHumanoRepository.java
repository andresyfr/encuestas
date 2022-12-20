package com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.model.repository;

import com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.model.entities.EncuestaModuloTalentoHumano;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EncuestaModuloTalentoHumanoRepository extends MongoRepository<EncuestaModuloTalentoHumano, Long>
{
}
