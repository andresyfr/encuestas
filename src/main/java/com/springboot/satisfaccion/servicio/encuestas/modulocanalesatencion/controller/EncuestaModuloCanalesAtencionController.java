package com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.controller;

import com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.model.entities.EncuestaModuloCanalesAtencion;
import com.springboot.satisfaccion.servicio.encuestas.modulocanalesatencion.service.EncuestaModuloCanalesAtencionService;
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
@RequestMapping(value="/api/satisfaccionservicio/encuestas/modulocanalesatencion")
public class EncuestaModuloCanalesAtencionController {

    private static final String pregunta1Valor = "1. ¿Identificó claramente a qué oficina o ventanilla dirigirse para realizar su trámite? ";
    private static final String pregunta2Valor = "2. ¿Cómo califica la comodidad limpieza y orden de las instalaciones? ";
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    private EncuestaModuloCanalesAtencionService encuestaModuloCanalesAtencionService;

    @GetMapping(value = "/index")
    public String indexModuloCanalesAtencion(Map<String, Object> model)
    {
        EncuestaModuloCanalesAtencion encuestaModuloCanalesAtencion = new EncuestaModuloCanalesAtencion();
        model.put("title", "Módulo Canales Atención");
        model.put("encuestaCanalesAtencion", encuestaModuloCanalesAtencion);
        model.put("pregunta1Valor", pregunta1Valor);
        model.put("pregunta2Valor", pregunta2Valor);
        return "moduloCanalesAtencionView";
    }

    @PostMapping(value = "/save")
    public String save(@Valid EncuestaModuloCanalesAtencion encuestaModuloCanalesAtencion, BindingResult result, Model model, RedirectAttributes flash)
    {
        if (result.hasErrors())
        {
            model.addAttribute("title", "Modulo encuesta canales atención");
            return "moduloCanalesAtencionView";
        }
        String flashMessage = "La encuesta se ha guardado satisfactoriamente";

        encuestaModuloCanalesAtencion.setPregunta1(pregunta1Valor);
        encuestaModuloCanalesAtencion.setPregunta2(pregunta2Valor);
        encuestaModuloCanalesAtencion.setFechaDiligenciada(dateFormat.format(new Date()));
        encuestaModuloCanalesAtencionService.save(encuestaModuloCanalesAtencion);
        flash.addFlashAttribute("success",flashMessage);

        return "redirect:/api/satisfaccionservicio/encuestas/modulocanalesatencion/index";
    }

    @GetMapping(value = "/all")
    public List<EncuestaModuloCanalesAtencion> getAll() { return encuestaModuloCanalesAtencionService.getAll();}

}
