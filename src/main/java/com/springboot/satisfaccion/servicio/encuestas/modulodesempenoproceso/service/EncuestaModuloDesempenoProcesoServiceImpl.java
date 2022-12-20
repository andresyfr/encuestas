package com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.service;

import com.springboot.satisfaccion.servicio.encuestas.commons.GenericServiceImpl;
import com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.model.entities.EncuestaModuloDesempenoProceso;
import com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.model.repository.EncuestaModuloDesempenoProcesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EncuestaModuloDesempenoProcesoServiceImpl extends GenericServiceImpl<EncuestaModuloDesempenoProceso, Long> implements EncuestaModuloDesempenoProcesoService
{
    @Autowired
    private EncuestaModuloDesempenoProcesoRepository encuestaModuloDesempenoProcesoRepository;

    @Override
    public CrudRepository<EncuestaModuloDesempenoProceso, Long> getDao() { return encuestaModuloDesempenoProcesoRepository; }

}
