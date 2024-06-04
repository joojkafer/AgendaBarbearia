package model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.sql.Date;

@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamento;
    private Date dataAgendamento;

    @Enumerated(EnumType.STRING)
    private HorarioEnum horario;

    @ManyToOne
    @JoinColumn(name = "fk_idBarbeiro")
    private Barbeiro barbeiro;

    @ManyToOne
    @JoinColumn(name = "fk_idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "agendamento")
    private List<ServicoAgendamento> servicosAgendamentos;

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

    public HorarioEnum getHorario() {
        return horario;
    }

    public void setHorario(HorarioEnum horario) {
        this.horario = horario;
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
