package org.barberini.sim_manager.converters;

import org.barberini.sim_manager.commands.NumerazioniCommand;
import org.barberini.sim_manager.commands.UtentiCommand;
import org.barberini.sim_manager.domains.Numerazioni;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NumerazioniToNumerazioniCommand implements Converter<Numerazioni,NumerazioniCommand>
{
    public NumerazioniCommand convert(Numerazioni source)
    {
        if(source == null)
        {
            return null;
        }

        final NumerazioniCommand numerazioniCommand = new NumerazioniCommand();

        numerazioniCommand.setDataAttivazione(source.getDataAttivazione());
        numerazioniCommand.setDataDisattivazione(source.getDataDisattivazione());
        numerazioniCommand.setNumero(source.getNumero());
        numerazioniCommand.setProfilo(source.getProfilo());
        numerazioniCommand.setSimCard(source.getSimCard());
        numerazioniCommand.setStato(source.getStato());
        numerazioniCommand.setUtente(source.getUtente());

        return numerazioniCommand;
    }
}
