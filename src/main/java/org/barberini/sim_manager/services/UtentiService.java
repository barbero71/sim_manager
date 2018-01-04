package org.barberini.sim_manager.services;

import org.barberini.sim_manager.models.Utenti;

import java.util.Set;

public interface UtentiService
{
    Set<Utenti> getUtenti();
    Utenti findById(Long l);
}
