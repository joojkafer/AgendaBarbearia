package model.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Barbeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idBarbeiro;
    private String nome;
    private boolean statusBarbeiro;

    @OneToMany(mappedBy = "barbeiro")
    private List<Agendamento> agendamentos;

    // Getters and Setters
    public int getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(int idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatusBarbeiro() {
        return statusBarbeiro;
    }

    public void setStatusBarbeiro(boolean statusBarbeiro) {
        this.statusBarbeiro = statusBarbeiro;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
