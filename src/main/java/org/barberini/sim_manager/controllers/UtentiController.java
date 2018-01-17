package org.barberini.sim_manager.controllers;

import org.barberini.sim_manager.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtentiController
{
    private UtentiService utentiService;

    @Autowired
    public UtentiController(UtentiService utentiService) {
        this.utentiService = utentiService;
    }

    @RequestMapping("/lista_utenti")
    public String getUtenti(Model model){

        model.addAttribute("utenti", utentiService.getUtenti());

        return "lista_utenti";

    }

    @RequestMapping("/users/show/{id}")
    public String userDetails(Model model, @PathVariable String id)
    {
        model.addAttribute("utente", utentiService.findById(new Long(id)));

        return "users/show";
    }
}
