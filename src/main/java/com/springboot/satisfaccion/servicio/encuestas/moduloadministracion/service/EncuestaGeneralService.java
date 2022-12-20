package com.springboot.satisfaccion.servicio.encuestas.moduloadministracion.service;

import com.springboot.satisfaccion.servicio.encuestas.moduloadministracion.model.entities.EncuestaGeneral;
import com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.model.entities.EncuestaModuloCanalesAtencion;
import com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.model.entities.EncuestaModuloDesempenoProceso;
import com.springboot.satisfaccion.servicio.encuestas.moduloexpectativa.model.entities.EncuestaModuloExpectativa;
import com.springboot.satisfaccion.servicio.encuestas.moduloresultado.model.entities.EncuestaModuloResultado;
import com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.model.entities.EncuestaModuloTalentoHumano;

import java.util.List;
import java.util.Map;

public interface EncuestaGeneralService
{
    List<EncuestaGeneral> obtenerEncuestasDentroDeAnio
            (
                    String anio,
                    List<EncuestaModuloCanalesAtencion> totalEncuestasModuloCanalesAtencion,
                    List<EncuestaModuloDesempenoProceso> totalEncuestasModuloDesempenoProceso,
                    List<EncuestaModuloExpectativa> totalEncuestasModuloExpectativa,
                    List<EncuestaModuloResultado> totalEncuestasModuloResultado,
                    List<EncuestaModuloTalentoHumano> totalEncuestasModuloTalentoHumano

            );

    Map<Integer,List<EncuestaGeneral>> agruparEncuestasMes(List<EncuestaGeneral> totalRespuestasObj);

    Map<Integer,List<EncuestaGeneral>> agruparEncuestasSemestre(List<EncuestaGeneral> totalRespuestasObj);

    Map<String,List<Integer>> agruparRespuestas(List<EncuestaGeneral> totalRespuestasObj);

    Map<String,Double> obtenerPromedio(Map<String,List<Integer>> respuestasAgrupadas);

}
