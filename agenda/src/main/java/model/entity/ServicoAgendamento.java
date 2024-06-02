package model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServicoAgendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idServicosAgendamento;

    @ManyToOne
    @JoinColumn(name = "fk_idAgendamento")
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "fk_idServico")
    private Servicos servicos;

    // Getters and Setters
    public int getIdServicosAgendamento() {
        return idServicosAgendamento;
    }

    public void setIdServicosAgendamento(int idServicosAgendamento) {
        this.idServicosAgendamento = idServicosAgendamento;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }
}
