package com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.model.repository;

import com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.model.entities.EncuestaModuloDesempenoProceso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EncuestaModuloDesempenoProcesoRepository extends MongoRepository<EncuestaModuloDesempenoProceso, Long>
{
}
