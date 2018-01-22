package org.barberini.sim_manager.controllers;

import org.barberini.sim_manager.commands.NumerazioniCommand;
import org.barberini.sim_manager.services.NumerazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("numerazioni/{numero}/show")
    public String numerazioniDetails(Model model, @PathVariable String numero)
    {
        model.addAttribute("numerazione", numerazioniService.findCommandById(new Long(numero)));

        return "numerazioni/numerazioni_show";

    }

    @RequestMapping("numerazioni/new")
    public String nuovaNumerazione(Model model)
    {
        model.addAttribute("numerazione", new NumerazioniCommand());

        return "numerazioni/numerazioni_form";
    }

    @RequestMapping("numerazioni/{numero}/update")
    public String updateNumerazione(@PathVariable("numero") String numero, Model model)
    {
        model.addAttribute("numerazione",numerazioniService.findCommandById(Long.valueOf(numero)));
        return "numerazioni/numerazioni_form";
    }

    @PostMapping
    @RequestMapping("numerazione")
    public String saveOrUpdate(@ModelAttribute NumerazioniCommand command)
    {
        NumerazioniCommand savedCommand = numerazioniService.saveNumerazioniCommand(command);

        return "redirect:/numerazioni/" + savedCommand.getNumero() + "/show";
    }

}
