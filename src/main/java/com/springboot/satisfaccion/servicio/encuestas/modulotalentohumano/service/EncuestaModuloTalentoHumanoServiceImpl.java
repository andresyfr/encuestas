package com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.service;

import com.springboot.satisfaccion.servicio.encuestas.commons.GenericServiceImpl;
import com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.model.entities.EncuestaModuloTalentoHumano;
import com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.model.repository.EncuestaModuloTalentoHumanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EncuestaModuloTalentoHumanoServiceImpl extends GenericServiceImpl<EncuestaModuloTalentoHumano, Long> implements EncuestaModuloTalentoHumanoService
{
    @Autowired
    private EncuestaModuloTalentoHumanoRepository encuestaModuloTalentoHumanoRepository;

    @Override
    public CrudRepository<EncuestaModuloTalentoHumano, Long> getDao() { return encuestaModuloTalentoHumanoRepository; }
}
