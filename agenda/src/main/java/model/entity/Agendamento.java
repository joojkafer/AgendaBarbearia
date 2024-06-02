package model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAgendamento;
    private Date dataAgendamento;

    @ManyToOne
    @JoinColumn(name = "fk_idHorarios")
    private HorarioEnum horarios;

    @ManyToOne
    @JoinColumn(name = "fk_idBarbeiro")
    private Barbeiro barbeiro;

    @ManyToOne
    @JoinColumn(name = "fk_idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "agendamento")
    private List<ServicoAgendamento> servicosAgendamentos;

    // Getters and Setters
    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public HorarioEnum getHorarios() {
        return horarios;
    }

    public void setHorarios(HorarioEnum horarios) {
        this.horarios = horarios;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ServicoAgendamento> getServicosAgendamentos() {
        return servicosAgendamentos;
    }

    public void setServicosAgendamentos(List<ServicoAgendamento> servicosAgendamentos) {
        this.servicosAgendamentos = servicosAgendamentos;
    }
}
