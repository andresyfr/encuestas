package com.springboot.satisfaccion.servicio.encuestas.moduloadministracion.controller;

import com.springboot.satisfaccion.servicio.encuestas.moduloadministracion.model.entities.EncuestaGeneral;
import com.springboot.satisfaccion.servicio.encuestas.moduloadministracion.service.EncuestaGeneralService;
import com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.model.entities.EncuestaModuloCanalesAtencion;
import com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.service.EncuestaModuloCanalesAtencionService;
import com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.model.entities.EncuestaModuloDesempenoProceso;
import com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.service.EncuestaModuloDesempenoProcesoService;
import com.springboot.satisfaccion.servicio.encuestas.moduloexpectativa.model.entities.EncuestaModuloExpectativa;
import com.springboot.satisfaccion.servicio.encuestas.moduloexpectativa.service.EncuestaModuloExpectativaService;
import com.springboot.satisfaccion.servicio.encuestas.moduloresultado.model.entities.EncuestaModuloResultado;
import com.springboot.satisfaccion.servicio.encuestas.moduloresultado.service.EncuestaModuloResultadoService;
import com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.model.entities.EncuestaModuloTalentoHumano;
import com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.service.EncuestaModuloTalentoHumanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/api/satisfaccionservicio/encuestas/administracion")
public class AdministracionController
{
    @Autowired
    private EncuestaGeneralService encuestaGeneralService;

    @Autowired
    private EncuestaModuloCanalesAtencionService encuestaModuloCanalesAtencionService;

    @Autowired
    private EncuestaModuloDesempenoProcesoService encuestaModuloDesempenoProcesoService;

    @Autowired
    private EncuestaModuloExpectativaService encuestaModuloExpectativaService;

    @Autowired
    private EncuestaModuloResultadoService encuestaModuloResultadoService;

    @Autowired
    private EncuestaModuloTalentoHumanoService encuestaModuloTalentoHumanoService;

    public List<EncuestaModuloCanalesAtencion> totalEncuestasModuloCanalesAtencion()
    {
        return encuestaModuloCanalesAtencionService.getAll();
    }

    public List<EncuestaModuloDesempenoProceso> totalEncuestasModuloDesempenoProceso()
    {
        return encuestaModuloDesempenoProcesoService.getAll();
    }

    public List<EncuestaModuloExpectativa> totalEncuestasModuloExpectativa()
    {
        return encuestaModuloExpectativaService.getAll();
    }

    public List<EncuestaModuloResultado> totalEncuestasModuloResultado()
    {
        return encuestaModuloResultadoService.getAll();
    }

    public List<EncuestaModuloTalentoHumano> totalEncuestasModuloTalentoHumano()
    {
        return encuestaModuloTalentoHumanoService.getAll();
    }

    @GetMapping(value = "/index")
    public String index(Model model)
    {
        model.addAttribute("title", "Bienvenido al Módulo de administración");

        return "moduloAdministracion_principalView";
    }

    @GetMapping(value = "/consultar/{anio}")
    public String vistaConsultarAnio( @RequestParam String anio,Map<String, Object> model)
    {
        List<EncuestaGeneral> listadoAnio = encuestaGeneralService.obtenerEncuestasDentroDeAnio(anio.substring(0,4),totalEncuestasModuloCanalesAtencion(),totalEncuestasModuloDesempenoProceso(),totalEncuestasModuloExpectativa(),totalEncuestasModuloResultado(),totalEncuestasModuloTalentoHumano());
        model.put("anio", anio);
        model.put("title", "Módulo de administración - lista completa de resultados para el año: " + anio);
        model.put("listadoAnio", listadoAnio);
        return "moduloAdministracionView";
    }

    @GetMapping(value = "/filtros/anual/{anio}")
    public String filtrarAnual( @PathVariable String anio,Model model)
    {
        List <EncuestaGeneral> obtenerEncuestasAnio = encuestaGeneralService.obtenerEncuestasDentroDeAnio(anio,totalEncuestasModuloCanalesAtencion(),totalEncuestasModuloDesempenoProceso(),totalEncuestasModuloExpectativa(),totalEncuestasModuloResultado(),totalEncuestasModuloTalentoHumano());
        Map<String, Double> listadoPromedioAnio = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(obtenerEncuestasAnio));

        model.addAttribute("title", "Promedio anual");
        model.addAttribute("listadoPromedioAnio", listadoPromedioAnio);

        return "moduloAdministracion_filtroAnualView";

    }

    @GetMapping(value = "/filtros/semestral/{anio}")
    public String filtrarSemestral( @PathVariable String anio,Model model)
    {
        List <EncuestaGeneral> obtenerEncuestasAnio = encuestaGeneralService.obtenerEncuestasDentroDeAnio(anio,totalEncuestasModuloCanalesAtencion(),totalEncuestasModuloDesempenoProceso(),totalEncuestasModuloExpectativa(),totalEncuestasModuloResultado(),totalEncuestasModuloTalentoHumano());
        Map<String, Double> listadoPromedioPrimerSemestre = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasSemestre(obtenerEncuestasAnio).get(1)));
        Map<String, Double> listadoPromedioSegundoSemestre = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasSemestre(obtenerEncuestasAnio).get(2)));

        model.addAttribute("title", "Promedio semestral");
        model.addAttribute("listadoPromedioPrimerSemestre", listadoPromedioPrimerSemestre);
        model.addAttribute("listadoPromedioSegundoSemestre", listadoPromedioSegundoSemestre);

        return "moduloAdministracion_filtroSemestralView";

    }

    @GetMapping(value = "/filtros/mensual/{anio}")
    public String filtrarMensual( @PathVariable String anio,Model model)
    {
        List <EncuestaGeneral> obtenerEncuestasAnio = encuestaGeneralService.obtenerEncuestasDentroDeAnio(anio,totalEncuestasModuloCanalesAtencion(),totalEncuestasModuloDesempenoProceso(),totalEncuestasModuloExpectativa(),totalEncuestasModuloResultado(),totalEncuestasModuloTalentoHumano());
        Map<String, Double> listadoPromedioMesEnero = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(1)));
        Map<String, Double> listadoPromedioMesFebrero = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(2)));
        Map<String, Double> listadoPromedioMesMarzo = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(3)));
        Map<String, Double> listadoPromedioMesAbril = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(4)));
        Map<String, Double> listadoPromedioMesMayo = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(5)));
        Map<String, Double> listadoPromedioMesJunio = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(6)));
        Map<String, Double> listadoPromedioMesJulio = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(7)));
        Map<String, Double> listadoPromedioMesAgosto = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(8)));
        Map<String, Double> listadoPromedioMesSeptiembre = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(9)));
        Map<String, Double> listadoPromedioMesOctubre = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(10)));
        Map<String, Double> listadoPromedioMesNoviembre = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(11)));
        Map<String, Double> listadoPromedioMesDiciembre = encuestaGeneralService.obtenerPromedio(encuestaGeneralService.agruparRespuestas(encuestaGeneralService.agruparEncuestasMes(obtenerEncuestasAnio).get(12)));

        model.addAttribute("title", "Promedio mensual");
        model.addAttribute("listadoPromedioMesEnero", listadoPromedioMesEnero);
        model.addAttribute("listadoPromedioMesFebrero", listadoPromedioMesFebrero);
        model.addAttribute("listadoPromedioMesMarzo", listadoPromedioMesMarzo);
        model.addAttribute("listadoPromedioMesAbril", listadoPromedioMesAbril);
        model.addAttribute("listadoPromedioMesMayo", listadoPromedioMesMayo);
        model.addAttribute("listadoPromedioMesJunio", listadoPromedioMesJunio);
        model.addAttribute("listadoPromedioMesJulio", listadoPromedioMesJulio);
        model.addAttribute("listadoPromedioMesAgosto", listadoPromedioMesAgosto);
        model.addAttribute("listadoPromedioMesSeptiembre", listadoPromedioMesSeptiembre);
        model.addAttribute("listadoPromedioMesOctubre", listadoPromedioMesOctubre);
        model.addAttribute("listadoPromedioMesNoviembre", listadoPromedioMesNoviembre);
        model.addAttribute("listadoPromedioMesDiciembre", listadoPromedioMesDiciembre);

        return "moduloAdministracion_filtroMensualView";

    }

}
