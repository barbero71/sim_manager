package org.barberini.sim_manager.services;

import org.barberini.sim_manager.commands.UtentiCommand;
import org.barberini.sim_manager.domains.Utenti;

import java.util.Set;

public interface UtentiService
{
    Set<Utenti> getUtenti();
    Utenti findById(Long l);

    UtentiCommand findCommandById(Long l);

    UtentiCommand saveUtentiCommand(UtentiCommand command);

}
