package model.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idServico;
    private String servico;
    private String descServico;
    private double valorServico;

    @OneToMany(mappedBy = "servicos")
    private List<ServicoAgendamento> servicosAgendamentos;

    // Getters and Setters
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getDescServico() {
        return descServico;
    }

    public void setDescServico(String descServico) {
        this.descServico = descServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public List<ServicoAgendamento> getServicosAgendamentos() {
        return servicosAgendamentos;
    }

    public void setServicosAgendamentos(List<ServicoAgendamento> servicosAgendamentos) {
        this.servicosAgendamentos = servicosAgendamentos;
    }
}
