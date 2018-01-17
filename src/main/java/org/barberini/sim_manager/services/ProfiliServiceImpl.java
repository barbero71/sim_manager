package org.barberini.sim_manager.services;

import org.barberini.sim_manager.domains.Profili;
import org.barberini.sim_manager.repositories.ProfiliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProfiliServiceImpl implements ProfiliService
{
    private final ProfiliRepository profiliRepository;

    @Autowired
    public ProfiliServiceImpl(ProfiliRepository profiliRepository) {
        this.profiliRepository = profiliRepository;
    }

    @Override
    public Set<Profili> getProfili() {

        Set<Profili> profiliSet = new HashSet<>();
        profiliRepository.findAll().iterator().forEachRemaining(profiliSet::add);

        return profiliSet;
    }

    @Override
    public Profili findById(Long l) {

        Optional<Profili> profiliOptional = profiliRepository.findById(l);

        if(!profiliOptional.isPresent())
        {
            throw new RuntimeException("Profilo non trovato!");
        }


        return profiliOptional.get();
    }
}
