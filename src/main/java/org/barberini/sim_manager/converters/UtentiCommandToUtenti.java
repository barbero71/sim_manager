package org.barberini.sim_manager.converters;


import org.barberini.sim_manager.commands.UtentiCommand;
import org.barberini.sim_manager.domains.Utenti;
import org.springframework.core.convert.converter.Converter;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.text.SimpleDateFormat;

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

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataAssegn = null;
        Date dataRitiro = null;
/*
        try {
            dataAssegn = new Date(dateFormat.parse("1900-01-01").getTime());
            dataRitiro = new Date(dateFormat.parse("2999-12-31").getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }


*/
        try
        {
            dataAssegn = new Date(dateFormat.parse(source.getDataAssegnazione().toString()).getTime());
            dataRitiro = new Date(dateFormat.parse(source.getDataRitiro().toString()).getTime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(dataAssegn);
        System.out.println(dataRitiro);

        final Utenti utenti = new Utenti();

        utenti.setId_utente(source.getId_utente());
        utenti.setNome(source.getNome().toUpperCase());
        utenti.setCognome(source.getCognome().toUpperCase());
        utenti.setMatricola(source.getMatricola().toUpperCase());
        utenti.setNumerazioni(source.getNumerazioni());
        utenti.setDataAssegnazione(dataAssegn);
        utenti.setDataRitiro(dataRitiro);

        return utenti;
    }

}
