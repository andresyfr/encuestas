package com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.controller;

import com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.model.entities.EncuestaModuloDesempenoProceso;
import com.springboot.satisfaccion.servicio.encuestas.modulodesempenoproceso.service.EncuestaModuloDesempenoProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/api/satisfaccionservicio/encuestas/modulodesempenoproceso")
public class EncuestaModuloDesempenoProcesoController {

    private static final String pregunta1Valor = "1. ¿Cómo califica la cantidad de tiempo que le tomó colocar su petición, queja, reclamo o sugerencia? ";
    private static final String pregunta2AValor = "2. ¿Cómo califica los siguientes aspectos de la entidad? \n" +
            "A. Rapidez y sencillez en la atención y en el acceso a los servicios";
    private static final String pregunta2BValor = "2. ¿Cómo califica los siguientes aspectos de la entidad? \n" +
            "B. Respeto por el turno de atención y por el cumplimiento de los horarios de atención.";
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    private EncuestaModuloDesempenoProcesoService encuestaModuloDesempenoProcesoService;

    @GetMapping(value = "/index")
    public String indexModuloDesempenoProceso(Map<String, Object> model)
    {
        EncuestaModuloDesempenoProceso encuestaModuloDesempenoProceso = new EncuestaModuloDesempenoProceso();
        model.put("title", "Módulo Desempeno Proceso");
        model.put("encuestaDesempenoProceso", encuestaModuloDesempenoProceso);
        model.put("pregunta1Valor", pregunta1Valor);
        model.put("pregunta2AValor", pregunta2AValor);
        model.put("pregunta2BValor", pregunta2BValor);
        return "moduloDesempenoProcesoView";
    }

    @PostMapping(value = "/save")
    public String save(@Valid EncuestaModuloDesempenoProceso encuestaModuloDesempenoProceso, BindingResult result, Model model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Modulo encuesta Desempeño Proceso");
            return "moduloDesempenoProcesoView";
        }
        String flashMessage = "La encuesta se ha guardado satisfactoriamente";

        encuestaModuloDesempenoProceso.setPregunta1(pregunta1Valor);
        encuestaModuloDesempenoProceso.setPregunta2a(pregunta2AValor);
        encuestaModuloDesempenoProceso.setPregunta2b(pregunta2BValor);
        encuestaModuloDesempenoProceso.setFechaDiligenciada(dateFormat.format(new Date()));
        encuestaModuloDesempenoProcesoService.save(encuestaModuloDesempenoProceso);
        flash.addFlashAttribute("success",flashMessage);

        return "redirect:/api/satisfaccionservicio/encuestas/modulodesempenoproceso/index";

    }

    @GetMapping(value = "/all")
    public List<EncuestaModuloDesempenoProceso> getAll() { return encuestaModuloDesempenoProcesoService.getAll(); }

    }
