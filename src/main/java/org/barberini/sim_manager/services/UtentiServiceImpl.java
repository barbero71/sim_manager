package org.barberini.sim_manager.services;

import org.barberini.sim_manager.commands.UtentiCommand;
import org.barberini.sim_manager.converters.UtentiCommandToUtenti;
import org.barberini.sim_manager.converters.UtentiToUtentiCommand;
import org.barberini.sim_manager.domains.Utenti;
import org.barberini.sim_manager.repositories.UtentiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UtentiServiceImpl implements UtentiService
{
    private final UtentiRepository utentiRepository;
    private final UtentiCommandToUtenti utentiCommandToUtenti;
    private final UtentiToUtentiCommand utentiToUtentiCommand;

    public UtentiServiceImpl(UtentiRepository utentiRepository, UtentiCommandToUtenti utentiCommandToUtenti, UtentiToUtentiCommand utentiToUtentiCommand)
    {
        this.utentiRepository = utentiRepository;
        this.utentiCommandToUtenti = utentiCommandToUtenti;
        this.utentiToUtentiCommand = utentiToUtentiCommand;
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

    @Override
    @Transactional
    public UtentiCommand saveUtentiCommand(UtentiCommand command) {

        Utenti detachedUtenti = utentiCommandToUtenti.convert(command);
        Utenti savedUtenti = utentiRepository.save(detachedUtenti);

        return utentiToUtentiCommand.convert(savedUtenti);

    }
}
