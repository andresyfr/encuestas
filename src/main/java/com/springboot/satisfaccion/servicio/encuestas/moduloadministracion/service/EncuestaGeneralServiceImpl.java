package com.springboot.satisfaccion.servicio.encuestas.moduloadministracion.service;


import com.springboot.satisfaccion.servicio.encuestas.moduloadministracion.model.entities.EncuestaGeneral;
import com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.model.entities.EncuestaModuloCanalesAtencion;
import com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.model.entities.EncuestaModuloDesempenoProceso;
import com.springboot.satisfaccion.servicio.encuestas.moduloexpectativa.model.entities.EncuestaModuloExpectativa;
import com.springboot.satisfaccion.servicio.encuestas.moduloresultado.model.entities.EncuestaModuloResultado;
import com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.model.entities.EncuestaModuloTalentoHumano;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EncuestaGeneralServiceImpl implements EncuestaGeneralService
{
    @Override
    public  List<EncuestaGeneral> obtenerEncuestasDentroDeAnio
        (
            String anio,
            List<EncuestaModuloCanalesAtencion> totalEncuestasModuloCanalesAtencion,
            List<EncuestaModuloDesempenoProceso> totalEncuestasModuloDesempenoProceso,
            List<EncuestaModuloExpectativa> totalEncuestasModuloExpectativa,
            List<EncuestaModuloResultado> totalEncuestasModuloResultado,
            List<EncuestaModuloTalentoHumano> totalEncuestasModuloTalentoHumano

        )
    {
        List<EncuestaGeneral> totalRespuestasObj = new ArrayList<>();

        if (!totalEncuestasModuloCanalesAtencion.isEmpty())
        {
            for (EncuestaModuloCanalesAtencion encuestasModuloCanalesAtencion :totalEncuestasModuloCanalesAtencion)
            {
                if (encuestasModuloCanalesAtencion.getFechaDiligenciada().substring(0,4).equals(anio))
                {
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloCanalesAtencion.getIdCiudadano(),encuestasModuloCanalesAtencion.getPregunta1(),encuestasModuloCanalesAtencion.getRespuesta1(),encuestasModuloCanalesAtencion.getFechaDiligenciada()));
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloCanalesAtencion.getIdCiudadano(),encuestasModuloCanalesAtencion.getPregunta2(),encuestasModuloCanalesAtencion.getRespuesta2(),encuestasModuloCanalesAtencion.getFechaDiligenciada()));
                }
            }
        }

        if (!totalEncuestasModuloDesempenoProceso.isEmpty())
        {
            for (EncuestaModuloDesempenoProceso encuestasModuloDesempenoProceso :totalEncuestasModuloDesempenoProceso)
            {
                if (encuestasModuloDesempenoProceso.getFechaDiligenciada().substring(0,4).equals(anio))
                {
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloDesempenoProceso.getIdCiudadano(),encuestasModuloDesempenoProceso.getPregunta1(),encuestasModuloDesempenoProceso.getRespuesta1(),encuestasModuloDesempenoProceso.getFechaDiligenciada()));
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloDesempenoProceso.getIdCiudadano(),encuestasModuloDesempenoProceso.getPregunta2a(),encuestasModuloDesempenoProceso.getRespuesta2a(),encuestasModuloDesempenoProceso.getFechaDiligenciada()));
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloDesempenoProceso.getIdCiudadano(),encuestasModuloDesempenoProceso.getPregunta2b(),encuestasModuloDesempenoProceso.getRespuesta2b(),encuestasModuloDesempenoProceso.getFechaDiligenciada()));
                }
            }
        }

        if (!totalEncuestasModuloExpectativa.isEmpty())
        {
            for (EncuestaModuloExpectativa encuestasModuloExpectativa :totalEncuestasModuloExpectativa)
            {
                if (encuestasModuloExpectativa.getFechaDiligenciada().substring(0,4).equals(anio))
                {
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloExpectativa.getIdCiudadano(),encuestasModuloExpectativa.getPregunta1(),encuestasModuloExpectativa.getRespuesta1(),encuestasModuloExpectativa.getFechaDiligenciada()));
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloExpectativa.getIdCiudadano(),encuestasModuloExpectativa.getPregunta2(),encuestasModuloExpectativa.getRespuesta2(),encuestasModuloExpectativa.getFechaDiligenciada()));
                }
            }
        }

        if (!totalEncuestasModuloResultado.isEmpty())
        {
            for (EncuestaModuloResultado encuestasModuloResultado :totalEncuestasModuloResultado)
            {
                if (encuestasModuloResultado.getFechaDiligenciada().substring(0,4).equals(anio))
                {
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloResultado.getIdCiudadano(),encuestasModuloResultado.getPregunta1(),encuestasModuloResultado.getRespuesta1(),encuestasModuloResultado.getFechaDiligenciada()));
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloResultado.getIdCiudadano(),encuestasModuloResultado.getPregunta2(),encuestasModuloResultado.getRespuesta2(),encuestasModuloResultado.getFechaDiligenciada()));
                }
            }
        }

        if (!totalEncuestasModuloTalentoHumano.isEmpty())
        {
            for (EncuestaModuloTalentoHumano encuestasModuloTalentoHumano :totalEncuestasModuloTalentoHumano)
            {
                if (encuestasModuloTalentoHumano.getFechaDiligenciada().substring(0,4).equals(anio))
                {
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloTalentoHumano.getIdCiudadano(),encuestasModuloTalentoHumano.getPregunta1a(),encuestasModuloTalentoHumano.getRespuesta1a(),encuestasModuloTalentoHumano.getFechaDiligenciada()));
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloTalentoHumano.getIdCiudadano(),encuestasModuloTalentoHumano.getPregunta1b(),encuestasModuloTalentoHumano.getRespuesta1b(),encuestasModuloTalentoHumano.getFechaDiligenciada()));
                    totalRespuestasObj.add(new EncuestaGeneral(encuestasModuloTalentoHumano.getIdCiudadano(),encuestasModuloTalentoHumano.getPregunta1c(),encuestasModuloTalentoHumano.getRespuesta1c(),encuestasModuloTalentoHumano.getFechaDiligenciada()));
                }
            }
        }
        return totalRespuestasObj;
    }

    @Override
    public Map<Integer,List<EncuestaGeneral>> agruparEncuestasMes(List<EncuestaGeneral> totalRespuestasObj)
    {
        HashMap<Integer, List<EncuestaGeneral>> agrupacionEncuestasPorMes = new HashMap<>();

        if(totalRespuestasObj != null)
        {
            for(EncuestaGeneral totalEncuestasList :totalRespuestasObj)
            {
                if (!agrupacionEncuestasPorMes.containsKey(Integer.valueOf(totalEncuestasList.getFechaDiligenciada().substring(5,7))))
                {
                    List<EncuestaGeneral> encuestas = new ArrayList<>();
                    encuestas.add(totalEncuestasList);
                    agrupacionEncuestasPorMes.put(Integer.valueOf(totalEncuestasList.getFechaDiligenciada().substring(5,7)), encuestas);
                }
                else
                {
                    agrupacionEncuestasPorMes.get(Integer.valueOf(totalEncuestasList.getFechaDiligenciada().substring(5,7))).add(totalEncuestasList);
                }
            }
        }
        return agrupacionEncuestasPorMes;
    }

    @Override
    public Map<Integer,List<EncuestaGeneral>> agruparEncuestasSemestre(List<EncuestaGeneral> totalRespuestasObj)
    {
        HashMap<Integer, List<EncuestaGeneral>> agrupacionEncuestasPorSemestre = new HashMap<>();
        if(totalRespuestasObj != null)
        {
            for(EncuestaGeneral totalEncuestasList :totalRespuestasObj)
            {
                int indicadorSemestre = (Integer.parseInt(totalEncuestasList.getFechaDiligenciada().substring(5,7)) <= 6)?1:2;

                if (!agrupacionEncuestasPorSemestre.containsKey(indicadorSemestre))
                {
                    List<EncuestaGeneral> encuestas = new ArrayList<>();
                    encuestas.add(totalEncuestasList);
                    agrupacionEncuestasPorSemestre.put(indicadorSemestre, encuestas);
                }
                else
                {
                    agrupacionEncuestasPorSemestre.get(indicadorSemestre).add(totalEncuestasList);
                }
            }
        }
        return agrupacionEncuestasPorSemestre;
    }

    @Override
    public Map<String,List<Integer>> agruparRespuestas(List<EncuestaGeneral> totalRespuestasObj)
    {
        HashMap<String, List<Integer>> agrupacionRespuestasTotales = new HashMap<>();
        if(totalRespuestasObj != null)
        {
            for (EncuestaGeneral totalRespuestasList :totalRespuestasObj)
            {
                if (!agrupacionRespuestasTotales.containsKey(totalRespuestasList.getPregunta()))
                {
                    List<Integer> respuestas = new ArrayList<>();
                    respuestas.add(totalRespuestasList.getRespuesta());

                    agrupacionRespuestasTotales.put(totalRespuestasList.getPregunta(), respuestas);
                }
                else
                {
                    agrupacionRespuestasTotales.get(totalRespuestasList.getPregunta()).add(totalRespuestasList.getRespuesta());
                }
            }
        }
        return agrupacionRespuestasTotales;
    }

    @Override
    public Map<String,Double> obtenerPromedio(Map<String,List<Integer>> respuestasAgrupadas)
    {
        HashMap<String, Double> promedioRespuestas = new HashMap<>();

        if(respuestasAgrupadas != null)
        {
            for (Map.Entry<String, List<Integer>> entry : respuestasAgrupadas.entrySet()) {
                double sum = 0;
                for (Integer respuestas : entry.getValue()) {
                    sum += respuestas;
                }
                promedioRespuestas.put(entry.getKey(), (sum / entry.getValue().size()));
            }
        }
        return promedioRespuestas;
    }
}
