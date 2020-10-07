package com.algaworks.gestaofloresta.controllers;

import com.algaworks.gestaofloresta.repository.ConvidadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvidadosController {

    @Autowired
    private ConvidadoRepository convidados;

    @GetMapping("/convidados")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("ListaConvidados");

        modelAndView.addObject("convidados", convidados.findAll());

        return modelAndView;
    }

}
