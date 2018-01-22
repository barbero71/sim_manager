package org.barberini.sim_manager.commands;

import org.barberini.sim_manager.domains.Numerazioni;
import org.barberini.sim_manager.domains.Stati;

import java.sql.Date;
import java.util.Set;

public class UtentiCommand
{
    private Long id_utente;
    private String nome;
    private String cognome;
    private String matricola;
    private Date dataAssegnazione;
    private Date dataRitiro;
    private Stati stato;

    private Set<Numerazioni> numerazioni;

    public UtentiCommand() {
    }

    public Long getId_utente() {
        return id_utente;
    }

    public void setId_utente(Long id_utente) {
        this.id_utente = id_utente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public Date getDataAssegnazione() {
        return dataAssegnazione;
    }

    public void setDataAssegnazione(Date dataAssegnazione) {
        this.dataAssegnazione = dataAssegnazione;
    }

    public Date getDataRitiro() {
        return dataRitiro;
    }

    public void setDataRitiro(Date dataRitiro) {
        this.dataRitiro = dataRitiro;
    }

    public Set<Numerazioni> getNumerazioni() {
        return numerazioni;
    }

    public void setNumerazioni(Set<Numerazioni> numerazioni) {
        this.numerazioni = numerazioni;
    }

    public Stati getStato() {
        return stato;
    }

    public void setStato(Stati stato) {
        this.stato = stato;
    }
}
