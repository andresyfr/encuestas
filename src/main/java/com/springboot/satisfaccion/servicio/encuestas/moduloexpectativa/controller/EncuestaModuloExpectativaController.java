package com.springboot.satisfaccion.servicio.encuestas.moduloexpectativa.controller;

import com.springboot.satisfaccion.servicio.encuestas.moduloexpectativa.model.entities.EncuestaModuloExpectativa;
import com.springboot.satisfaccion.servicio.encuestas.moduloexpectativa.service.EncuestaModuloExpectativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/api/satisfaccionservicio/encuestas/moduloexpectativa")
public class EncuestaModuloExpectativaController
{

    private static final String pregunta1Valor = "1. ¿Cómo califica la calidad de la prestación del servicio ofrecido por la entidad, cumplió sus expectativas?";

    private static final String pregunta2Valor = "2. ¿Recomendaría la entidad por el servicio prestado?";
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    @Autowired
    private EncuestaModuloExpectativaService encuestaModuloExpectativaService;

    @GetMapping(value = "/index")
    public String indexModuloExpectativa(Map<String, Object> model)
    {
        EncuestaModuloExpectativa encuestaModuloExpectativa = new EncuestaModuloExpectativa();
        model.put("title", "Módulo expectativa");
        model.put("encuestaExpectativa", encuestaModuloExpectativa);
        model.put("pregunta1Valor", pregunta1Valor);
        model.put("pregunta2Valor", pregunta2Valor);
        return "moduloExpectativaView";
    }

    @PostMapping(value = "/save")
    public String save(@Valid EncuestaModuloExpectativa encuestaModuloExpectativa, BindingResult result, Model model, RedirectAttributes flash)
    {
        if(result.hasErrors())
        {
            model.addAttribute("title", "Modulo encuesta expectativa");
            return "moduloExpectativaView";
        }
        String flashMessage = "La encuesta se ha guardado satisfactoriamente";

        encuestaModuloExpectativa.setPregunta1(pregunta1Valor);
        encuestaModuloExpectativa.setPregunta2(pregunta2Valor);
        encuestaModuloExpectativa.setFechaDiligenciada(dateFormat.format(new Date()));
        encuestaModuloExpectativaService.save(encuestaModuloExpectativa);
        flash.addFlashAttribute("success",flashMessage);

        return "redirect:/api/satisfaccionservicio/encuestas/moduloexpectativa/index";
    }

    @GetMapping(value = "/all")
    public List<EncuestaModuloExpectativa> getAll()
    {
        return encuestaModuloExpectativaService.getAll();
    }
}
