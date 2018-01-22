package org.barberini.sim_manager.services;

import org.barberini.sim_manager.commands.NumerazioniCommand;
import org.barberini.sim_manager.converters.NumerazioniCommandToNumerazioni;
import org.barberini.sim_manager.converters.NumerazioniToNumerazioniCommand;
import org.barberini.sim_manager.domains.Numerazioni;
import org.barberini.sim_manager.repositories.NumerazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class NumerazioniServiceImpl implements NumerazioniService
{
    private final NumerazioniRepository numerazioniRepository;
    private final NumerazioniCommandToNumerazioni numerazioniCommandToNumerazioni;
    private final NumerazioniToNumerazioniCommand numerazioniToNumerazioniCommand;

    @Autowired
    public NumerazioniServiceImpl(NumerazioniRepository numerazioniRepository, NumerazioniCommandToNumerazioni numerazioniCommandToNumerazioni, NumerazioniToNumerazioniCommand numerazioniToNumerazioniCommand) {
        this.numerazioniRepository = numerazioniRepository;
        this.numerazioniCommandToNumerazioni = numerazioniCommandToNumerazioni;
        this.numerazioniToNumerazioniCommand = numerazioniToNumerazioniCommand;
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

    @Override
    public NumerazioniCommand findCommandById(Long l) {
        return numerazioniToNumerazioniCommand.convert(findById(l));
    }

    @Override
    @Transactional
    public NumerazioniCommand saveNumerazioniCommand(NumerazioniCommand command) {

        Numerazioni detachedNumerazioni = numerazioniCommandToNumerazioni.convert(command);
        Numerazioni savedNumerazioni = numerazioniRepository.save(detachedNumerazioni);

        return numerazioniToNumerazioniCommand.convert(savedNumerazioni);
    }
}
