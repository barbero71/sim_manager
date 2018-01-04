package org.barberini.sim_manager.services;

import org.barberini.sim_manager.models.Utenti;
import org.barberini.sim_manager.repositories.UtentiRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UtentiServiceImpl implements UtentiService
{
    private final UtentiRepository utentiRepository;

    public UtentiServiceImpl(UtentiRepository utentiRepository) {
        this.utentiRepository = utentiRepository;
    }

    @Override
    public Set<Utenti> getUtenti() {

        Set<Utenti> utentiSet = new HashSet<>();
        utentiRepository.findAll().iterator().forEachRemaining((utentiSet::add));

        return utentiSet;
    }

    @Override
    public Utenti findById(Long l) {

        Optional<Utenti> utentiOptional = utentiRepository.findById(l);

        if(!utentiOptional.isPresent())
        {
            throw new RuntimeException("Utente non trovato!");
        }

        return utentiOptional.get();
    }
}
