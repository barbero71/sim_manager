package org.barberini.sim_manager.converters;

import lombok.Synchronized;
import org.barberini.sim_manager.commands.UtentiCommand;
import org.barberini.sim_manager.domains.Utenti;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UtentiToUtentiCommand implements Converter<Utenti, UtentiCommand>
{
    @Override
    @Synchronized
    @Nullable
    public UtentiCommand convert(Utenti source) {

        final UtentiCommand utentiCommand = new UtentiCommand();

        utentiCommand.setId_utente(source.getId_utente());
        utentiCommand.setNome(source.getNome());
        utentiCommand.setCognome(source.getCognome());
        utentiCommand.setMatricola(source.getMatricola());
        utentiCommand.setNumerazioni(source.getNumerazioni());
        utentiCommand.setDataAssegnazione(source.getDataAssegnazione());
        utentiCommand.setDataRitiro(source.getDataRitiro());

        return utentiCommand;
    }
}
