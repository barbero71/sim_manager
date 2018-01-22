package org.barberini.sim_manager.converters;

import lombok.Synchronized;
import org.barberini.sim_manager.commands.NumerazioniCommand;
import org.barberini.sim_manager.domains.Numerazioni;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Component
public class NumerazioniCommandToNumerazioni implements Converter<NumerazioniCommand, Numerazioni>
{
    @Synchronized
    @Nullable
    @Override
    public Numerazioni convert(NumerazioniCommand source)
    {
        if(source == null)
        {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataAttiv = null;
        Date dataDis = null;

        try
        {
            dataAttiv = new Date(dateFormat.parse(source.getDataAttivazione().toString()).getTime());
            dataDis = new Date(dateFormat.parse(source.getDataDisattivazione().toString()).getTime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(dataAttiv);
        System.out.println(dataDis);

        final Numerazioni numerazioni = new Numerazioni();

        numerazioni.setDataAttivazione(dataAttiv);
        numerazioni.setDataDisattivazione(dataDis);
        numerazioni.setNumero(source.getNumero());
        numerazioni.setProfilo(source.getProfilo());
        numerazioni.setSimCard(source.getSimCard());
        numerazioni.setStato(source.getStato());
        numerazioni.setUtente(source.getUtente());

        return numerazioni;
    }
}
