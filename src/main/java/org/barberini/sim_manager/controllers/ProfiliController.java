package org.barberini.sim_manager.controllers;

import org.barberini.sim_manager.services.ProfiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfiliController
{
    private ProfiliService profiliService;

    @Autowired
    public ProfiliController(ProfiliService profiliService) {
        this.profiliService = profiliService;
    }

    @RequestMapping("/lista_profili")
    public String getProfili(Model model)
    {
        model.addAttribute("profili", profiliService.getProfili());

        return "lista_profili";
    }
}
