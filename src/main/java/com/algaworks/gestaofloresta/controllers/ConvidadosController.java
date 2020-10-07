package com.algaworks.gestaofloresta.controllers;

import com.algaworks.gestaofloresta.model.Convidado;
import com.algaworks.gestaofloresta.repository.ConvidadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

    @Autowired
    private ConvidadoRepository convidados;

    @PostMapping
    public String salvar(Convidado convidado) {
        this.convidados.save(convidado);
        return "redirect:/convidados";
    }

    @GetMapping
    public ModelAndView listar() {

        ModelAndView modelAndView = new ModelAndView("ListaConvidados");
        modelAndView.addObject(new Convidado());
        modelAndView.addObject("convidados", convidados.findAll());

        return modelAndView;
    }

}
