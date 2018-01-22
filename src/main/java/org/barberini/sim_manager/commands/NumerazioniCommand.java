package org.barberini.sim_manager.commands;

import org.barberini.sim_manager.domains.*;
import org.springframework.core.convert.converter.Converter;

import java.sql.Date;
import java.util.Set;

public class NumerazioniCommand
{
    private Long numero;
    private Stati stato;
    private Date dataAttivazione;
    private Date dataDisattivazione;

    private Set<SimCard> simCard;
    private Profili profilo;
    private Utenti utente;

    public NumerazioniCommand() {
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Stati getStato() {
        return stato;
    }

    public void setStato(Stati stato) {
        this.stato = stato;
    }

    public Date getDataAttivazione() {
        return dataAttivazione;
    }

    public void setDataAttivazione(Date dataAttivazione) {
        this.dataAttivazione = dataAttivazione;
    }

    public Date getDataDisattivazione() {
        return dataDisattivazione;
    }

    public void setDataDisattivazione(Date dataDisattivazione) {
        this.dataDisattivazione = dataDisattivazione;
    }

    public Set<SimCard> getSimCard() {
        return simCard;
    }

    public void setSimCard(Set<SimCard> simCard) {
        this.simCard = simCard;
    }

    public Profili getProfilo() {
        return profilo;
    }

    public void setProfilo(Profili profilo) {
        this.profilo = profilo;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }
}
