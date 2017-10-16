package org.barberini.sim_manager.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="PH_NUMERAZIONI")
public class Numerazioni
{
    @Id
    private Long numero;
    private Date dataAttivazione;
    private Date dataDisattivazione;

    @OneToMany(mappedBy = "numerazione", cascade = CascadeType.ALL)
    private Set<SimCard> simCard;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="ID_PROFILO")
    private Profili profilo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_UTENTE")
    private Utenti utente;

    public void setSimCard(Set<SimCard> simCard) {
        this.simCard = simCard;
    }

    public void setProfilo(Profili profilo) {
        this.profilo = profilo;
    }

    public Set<SimCard> getSimCard() {
        return simCard;
    }

    public Profili getProfilo() {
        return profilo;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }


    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
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


}
