package org.barberini.sim_manager.services;

import org.barberini.sim_manager.commands.NumerazioniCommand;
import org.barberini.sim_manager.domains.Numerazioni;

import java.util.Set;

public interface NumerazioniService
{
    Set<Numerazioni> getNumerazioni();
    Numerazioni findById(Long l);

    NumerazioniCommand findCommandById(Long l);

    NumerazioniCommand saveNumerazioniCommand(NumerazioniCommand command);
}
