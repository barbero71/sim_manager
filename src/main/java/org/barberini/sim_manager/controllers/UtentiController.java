package org.barberini.sim_manager.controllers;

import org.barberini.sim_manager.commands.UtentiCommand;
import org.barberini.sim_manager.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/utenti/{id}/show")
    public String userDetails(Model model, @PathVariable String id)
    {
        model.addAttribute("utente", utentiService.findCommandById(new Long(id)));

        return "utenti/utenti_show";
    }

    @RequestMapping("/utenti/new")
    public String nuovoUtente(Model model)
    {
        model.addAttribute("utente", new UtentiCommand());

        return "utenti/utenti_form";
    }

    @RequestMapping("/users/{id}/update")
    public String updateUtente(@PathVariable String id, Model model)
    {
        model.addAttribute("utente", utentiService.findCommandById(Long.valueOf(id)));
        return "utenti/utenti_form";
    }

    @PostMapping
    @RequestMapping("utente")
    public String saveOrUpdate(@ModelAttribute UtentiCommand command){
        UtentiCommand savedCommand = utentiService.saveUtentiCommand(command);

        return "redirect:/utenti/" + savedCommand.getId_utente() + "/show";
    }
}
