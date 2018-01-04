package org.barberini.sim_manager.controllers;

import org.barberini.sim_manager.services.NumerazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NumerazioniController
{
    private NumerazioniService numerazioniService;

    @Autowired
    public NumerazioniController(NumerazioniService numerazioniService) {
        this.numerazioniService = numerazioniService;
    }

    @RequestMapping("lista_numerazioni")
    public String getNumerazioni(Model model)
    {
        model.addAttribute("numerazioni", numerazioniService.getNumerazioni());


        return "lista_numerazioni";
    }
}
