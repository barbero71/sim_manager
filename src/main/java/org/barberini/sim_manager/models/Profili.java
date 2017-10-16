package org.barberini.sim_manager.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="PH_PROFILI")
public class Profili
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profilo;

    private Operatori operatore;

    private String descri;
    private Long minuti;
    private Long sms;
    private Long dati;

    @OneToMany(mappedBy = "profilo")
    private Set<Opzioni> opzioni;

    @OneToMany(mappedBy = "profilo")
    private Set<Numerazioni> numerazioni;

    private String note;


    public Set<Numerazioni> getNumerazioni() {
        return numerazioni;
    }

    public void setNumerazioni(Set<Numerazioni> numerazioni) {
        this.numerazioni = numerazioni;
    }

    public Long getId_profilo() {
        return id_profilo;
    }

    public void setId_profilo(Long id_profilo) {
        this.id_profilo = id_profilo;
    }

    public Operatori getOperatore() {
        return operatore;
    }

    public void setOperatore(Operatori operatore) {
        this.operatore = operatore;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public Long getMinuti() {
        return minuti;
    }

    public void setMinuti(Long minuti) {
        this.minuti = minuti;
    }

    public Long getSms() {
        return sms;
    }

    public void setSms(Long sms) {
        this.sms = sms;
    }

    public Long getDati() {
        return dati;
    }

    public void setDati(Long dati) {
        this.dati = dati;
    }

    public Set<Opzioni> getOpzioni() {
        return opzioni;
    }

    public void setOpzioni(Set<Opzioni> opzioni) {
        this.opzioni = opzioni;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
