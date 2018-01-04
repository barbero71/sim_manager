package org.barberini.sim_manager.services;

import org.barberini.sim_manager.models.Numerazioni;

import java.util.Set;

public interface NumerazioniService
{
    Set<Numerazioni> getNumerazioni();
    Numerazioni findById(Long l);
}
