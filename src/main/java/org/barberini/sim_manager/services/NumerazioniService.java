package org.barberini.sim_manager.services;

import org.barberini.sim_manager.domains.Numerazioni;

import java.util.Set;

public interface NumerazioniService
{
    Set<Numerazioni> getNumerazioni();
    Numerazioni findById(Long l);
}
