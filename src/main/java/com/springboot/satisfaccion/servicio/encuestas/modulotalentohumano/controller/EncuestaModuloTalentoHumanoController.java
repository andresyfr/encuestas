package com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.controller;

import com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.model.entities.EncuestaModuloTalentoHumano;
import com.springboot.satisfaccion.servicio.encuestas.modulotalentohumano.service.EncuestaModuloTalentoHumanoService;
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
@RequestMapping(value="/api/satisfaccionservicio/encuestas/modulotalentohumano")
public class EncuestaModuloTalentoHumanoController {
    private static final String pregunta1AValor = "1. ¿Cómo califica los siguientes aspectos del servidor que lo atendió́? \n"
            + "A. Presentación personal.";
    private static final String pregunta1BValor = "1. ¿Cómo califica los siguientes aspectos del servidor que lo atendió́? \n"
            + "B. Actitud y amabilidad.";
    private static final String pregunta1CValor = "1. ¿Cómo califica los siguientes aspectos del servidor que lo atendió́? \n"
            + "C. Claridad, calidad y conocimiento de la asesoría recibida.";
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    private EncuestaModuloTalentoHumanoService encuestaModuloTalentoHumanoService;

    @GetMapping(value = "/index")
    public String indexModuloTalentoHumano(Map<String, Object> model)
    {
        EncuestaModuloTalentoHumano encuestaModuloTalentoHumano = new EncuestaModuloTalentoHumano();
        model.put("title", "Módulo Talento Humano");
        model.put("encuestaTalentoHumano", encuestaModuloTalentoHumano);
        model.put("pregunta1AValor", pregunta1AValor);
        model.put("pregunta1BValor", pregunta1BValor);
        model.put("pregunta1CValor", pregunta1CValor);
        return "moduloTalentoHumanoView";
    }


    @PostMapping(value = "/save")
    public String save(@Valid EncuestaModuloTalentoHumano encuestaModuloTalentoHumano, BindingResult result, Model model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Modulo encuesta Talento Humano");
            return "moduloTalentoHumanoView";
        }
        String flashMessage = "La encuesta se ha guardado satisfactoriamente";

        encuestaModuloTalentoHumano.setPregunta1a(pregunta1AValor);
        encuestaModuloTalentoHumano.setPregunta1b(pregunta1BValor);
        encuestaModuloTalentoHumano.setPregunta1c(pregunta1CValor);
        encuestaModuloTalentoHumano.setFechaDiligenciada(dateFormat.format(new Date()));
        encuestaModuloTalentoHumanoService.save(encuestaModuloTalentoHumano);
        flash.addFlashAttribute("success",flashMessage);

        return "redirect:/api/satisfaccionservicio/encuestas/modulotalentohumano/index";

    }

    @GetMapping(value = "/all")
    public List<EncuestaModuloTalentoHumano> getAll() { return encuestaModuloTalentoHumanoService.getAll(); }

}
