package org.barberini.sim_manager.services;

import org.barberini.sim_manager.domains.Numerazioni;
import org.barberini.sim_manager.repositories.NumerazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class NumerazioniServiceImpl implements NumerazioniService
{
    private final NumerazioniRepository numerazioniRepository;

    @Autowired
    public NumerazioniServiceImpl(NumerazioniRepository numerazioniRepository) {
        this.numerazioniRepository = numerazioniRepository;
    }

    @Override
    public Set<Numerazioni> getNumerazioni() {

        Set<Numerazioni> numerazioniSet = new HashSet<>();
        numerazioniRepository.findAll().iterator().forEachRemaining(numerazioniSet::add);

        return numerazioniSet;
    }

    @Override
    public Numerazioni findById(Long l) {

        Optional<Numerazioni> numerazioniOptional = numerazioniRepository.findById(l);

        if(!numerazioniOptional.isPresent())
        {
            throw new RuntimeException("Numerazione non trovata!");
        }

        return numerazioniOptional.get();
    }
}
