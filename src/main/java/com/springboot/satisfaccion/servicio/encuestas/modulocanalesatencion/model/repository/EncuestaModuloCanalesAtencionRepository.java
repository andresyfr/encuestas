package com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.model.repository;

import com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.model.entities.EncuestaModuloCanalesAtencion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EncuestaModuloCanalesAtencionRepository extends MongoRepository<EncuestaModuloCanalesAtencion, Long>
{
}
