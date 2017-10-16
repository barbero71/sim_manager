package org.barberini.sim_manager.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PH_UTENTI")
public class Utenti
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_utente;
    private String nome;
    private String cognome;
    private String matricola;

    //todo: Aggiungere Reparto da enum o testo o tabella

    @OneToMany(mappedBy = "utente")
    private Set<Numerazioni> numerazioni;

    private Date dataAssegnazione;
    private Date dataRitiro;


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

    public Set<Numerazioni> getNumerazioni() {
        return numerazioni;
    }

    public void setNumerazioni(Set<Numerazioni> numerazioni) {
        this.numerazioni = numerazioni;
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
}
