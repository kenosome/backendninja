package com.udemy.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.udemy.model.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PersonasController {

    private static final String VISTA_PERSONAS = "personas";
    private static final String VISTA_PERSONA = "persona";
    private static final String VISTA_GET_PERSONA_BY_ID = "getPersonaById";
    private static final String VISTA_FORM_PERSONA = "personform";
    private static final String VISTA_RESULTADO_ADD_PERSONA = "personaresultview";

    @GetMapping("personas")
    public ModelAndView people(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kenny",20));
        personas.add(new Persona("Alejandro",18));
        personas.add(new Persona("Kevin",18));
        personas.add(new Persona("Jeison",29));

        ModelAndView modelo = new ModelAndView(VISTA_PERSONAS);
        modelo.addObject("personas",personas);
        return  modelo;
    }

//    @GetMapping("persona")
//    public ModelAndView person(@RequestParam(name = "nombre",required = false,defaultValue = "") String nombre){
//
//
//        ModelAndView modelo = new ModelAndView(VISTA_PERSONA);
//        modelo.addObject("nombre",nombre);
//        return  modelo;
//    }

    @GetMapping("persona")
    public String personForm(Model modelo){
        modelo.addAttribute("person",new Persona());
        return  VISTA_FORM_PERSONA;
    }

    @PostMapping("persona")
    public ModelAndView addPerson(@ModelAttribute("person") Persona persona){
        ModelAndView modelo = new ModelAndView(VISTA_RESULTADO_ADD_PERSONA);
        modelo.addObject("person",persona);

        return modelo;
    }

    @GetMapping("persona/{id}")
    public ModelAndView getPersonaById(@PathVariable("id") String id){
        ModelAndView modelo = new ModelAndView(VISTA_GET_PERSONA_BY_ID);
        Map<Integer, Persona> mapPersonas = new HashMap<>();
        mapPersonas.put(1,new Persona("Kenny",20));
        mapPersonas.put(2,new Persona("Alejandro",18));
        mapPersonas.put(3,new Persona("Kevin",18));
        mapPersonas.put(4,new Persona("Jeison",29));

        Persona persona = mapPersonas.get(Integer.parseInt(id));

        if (persona!=null){
            modelo.addObject("nombre",persona.getNombre());
        }

        return modelo;

    }
}
