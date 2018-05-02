package com.udemy.controller;

import com.udemy.model.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/example")
public class ExampleController {

    private final String VISTA_EXAMPLE = "example";

    public ExampleController() {

    }

    @GetMapping("/examplestring")
    public String exampleString( Model modelo){
        Persona persona = new Persona();
        persona.setNombre("Kenny");
        persona.setEdad(20);

        modelo.addAttribute("persona",persona);
        return VISTA_EXAMPLE;
    }
    @GetMapping("/examplemodel")
    public ModelAndView exampleModel(){
        Persona persona = new Persona();
        persona.setNombre("Jeison");
        persona.setEdad(29);

        ModelAndView modelo = new ModelAndView(VISTA_EXAMPLE);
        modelo.addObject("persona",persona);
        return modelo;
    }



}
