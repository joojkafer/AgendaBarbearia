package model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "barbeiro")
public class Barbeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBarbeiro;
    private String nome;
    private boolean statusBarbeiro;

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
}
