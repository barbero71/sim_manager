package org.barberini.sim_manager.services;

import org.barberini.sim_manager.models.Profili;

import java.util.Set;

public interface ProfiliService
{
    Set<Profili> getProfili();
    Profili findById(Long l);
}
