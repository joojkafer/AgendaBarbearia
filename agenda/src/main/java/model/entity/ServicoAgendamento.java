package model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "servicosAgendamento")
public class ServicoAgendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicosAgendamento;

    @ManyToOne
    @JoinColumn(name = "fk_idAgendamento")
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "fk_idServico")
    private Servicos servico;

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

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }
}
