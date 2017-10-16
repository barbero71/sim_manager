package org.barberini.sim_manager.models;

import javax.persistence.*;

@Entity
@Table(name="PH_OPZIONI")
public class Opzioni
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_opzione;
    private String descri;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_PROFILO")
    private Profili profilo;

    public Long getId_opzione() {
        return id_opzione;
    }

    public void setId_opzione(Long id_opzione) {
        this.id_opzione = id_opzione;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }
}
