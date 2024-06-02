package model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atendente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAtendente;
    private String nome;
    private String cpf;
    private String userLogin;
    private String userPassword;

    // Getters and Setters
    public int getIdAtendente() {
        return idAtendente;
    }

    public void setIdAtendente(int idAtendente) {
        this.idAtendente = idAtendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
