package org.barberini.sim_manager.models;

import javax.persistence.*;

@Entity
@Table(name="PH_SIMCARD")
public class SimCard
{
    @Id
    private String iccid;
    private String pin;
    private String puk;

    private Operatori operatore;
    private Stati stato;

    @ManyToOne
    private Numerazioni numerazione;


    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPuk() {
        return puk;
    }

    public void setPuk(String puk) {
        this.puk = puk;
    }

    public Operatori getOperatore() {
        return operatore;
    }

    public void setOperatore(Operatori operatore) {
        this.operatore = operatore;
    }

    public Stati getStato() {
        return stato;
    }

    public void setStato(Stati stato) {
        this.stato = stato;
    }

    public Numerazioni getNumerazione() {
        return numerazione;
    }

    public void setNumerazione(Numerazioni numerazione) {
        this.numerazione = numerazione;
    }
}
