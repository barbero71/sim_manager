package org.barberini.sim_manager.converters;


import org.barberini.sim_manager.commands.UtentiCommand;
import org.barberini.sim_manager.domains.Utenti;
import org.springframework.core.convert.converter.Converter;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UtentiCommandToUtenti implements Converter<UtentiCommand, Utenti>
{
    @Synchronized
    @Nullable
    @Override
    public Utenti convert(UtentiCommand source)
    {
        if(source==null)
        {
            return null;
        }

        final Utenti utenti = new Utenti();

        utenti.setId_utente(source.getId_utente());
        utenti.setNome(source.getNome());
        utenti.setCognome(source.getCognome());
        utenti.setMatricola(source.getMatricola());
        utenti.setNumerazioni(source.getNumerazioni());
        utenti.setDataAssegnazione(source.getDataAssegnazione());
        utenti.setDataRitiro(source.getDataRitiro());

        return utenti;
    }

}
