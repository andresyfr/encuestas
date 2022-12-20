package com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.service;

import com.springboot.satisfaccion.servicio.encuestas.commons.GenericServiceImpl;
import com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.model.entities.EncuestaModuloCanalesAtencion;
import com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.model.repository.EncuestaModuloCanalesAtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EncuestaModuloCanalesAtencionServiceImpl extends GenericServiceImpl<EncuestaModuloCanalesAtencion, Long> implements EncuestaModuloCanalesAtencionService
{
    @Autowired
    private EncuestaModuloCanalesAtencionRepository encuestaModuloCanalesAtencionRepository;

    @Override
    public CrudRepository<EncuestaModuloCanalesAtencion, Long> getDao() { return encuestaModuloCanalesAtencionRepository; }
}
