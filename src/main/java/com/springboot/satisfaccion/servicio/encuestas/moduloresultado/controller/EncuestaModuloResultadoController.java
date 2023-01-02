package com.springboot.satisfaccion.servicio.encuestas.moduloresultado.controller;

import com.springboot.satisfaccion.servicio.encuestas.moduloresultado.model.entities.EncuestaModuloResultado;
import com.springboot.satisfaccion.servicio.encuestas.moduloresultado.service.EncuestaModuloResultadoService;
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
@RequestMapping(value="/api/satisfaccionservicio/encuestas/moduloresultado")
public class EncuestaModuloResultadoController
{
    private static final String pregunta1Valor = "1. ¿La entidad le dió respuesta efectiva y oportuna a su requerimiento?";
    private static final String pregunta2Valor = "2. ¿La entidad cumplió́ con los acuerdos, tiempos o compromisos establecidos?";
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    @Autowired
    private EncuestaModuloResultadoService encuestaModuloResultadoService;

    @GetMapping(value = "/index")
    public String indexModuloResultado(Map<String, Object> model)
    {
        EncuestaModuloResultado encuestaModuloResultado = new EncuestaModuloResultado();
        model.put("title", "Módulo resultado");
        model.put("encuestaResultado", encuestaModuloResultado);
        model.put("pregunta1Valor", pregunta1Valor);
        model.put("pregunta2Valor", pregunta2Valor);
        return "moduloResultadoView";
    }
    @GetMapping(value = "/index/{cedula}")
    public String indexModuloExpectativa(@PathVariable String cedula, Map<String, Object> model)
    {
        EncuestaModuloResultado encuestaModuloResultado = new EncuestaModuloResultado();
        model.put("title", "Módulo resultado");
        model.put("encuestaResultado", encuestaModuloResultado);
        model.put("pregunta1Valor", pregunta1Valor);
        model.put("pregunta2Valor", pregunta2Valor);
        model.put("cedula", cedula);
        return "moduloResultadoView";
    }

    @PostMapping(value = "/save/{cedula}")
    public String save(@Valid EncuestaModuloResultado encuestaModuloResultado, BindingResult result, Model model, RedirectAttributes flash, @PathVariable String cedula)
    {
        if(result.hasErrors())
        {
            model.addAttribute("title", "Modulo encuesta resultado");
            return "moduloResultadoView";
        }
        String flashMessage = "La encuesta se ha guardado satisfactoriamente";

        encuestaModuloResultado.setPregunta1(pregunta1Valor);
        encuestaModuloResultado.setPregunta2(pregunta2Valor);
        encuestaModuloResultado.setFechaDiligenciada(dateFormat.format(new Date()));
        if(!(cedula.isEmpty() || cedula.equals("null"))){encuestaModuloResultado.setIdCiudadano(Long.parseLong(cedula));}
        encuestaModuloResultadoService.save(encuestaModuloResultado);
        flash.addFlashAttribute("success",flashMessage);

        if(cedula.isEmpty() || cedula.equals("null"))
        {
            return "redirect:/api/satisfaccionservicio/encuestas/moduloresultado/index";
        }
        return "moduloAdministracionFin";
    }

    @GetMapping(value = "/all")
    public List<EncuestaModuloResultado> getAll()
    {
        return encuestaModuloResultadoService.getAll();
    }
}
