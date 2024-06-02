package model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.entity.Atendente;

public class AtendenteRepository {
    private List<Atendente> atendentes = new ArrayList<>();

    public List<Atendente> findAll() {
        return atendentes;
    }

    public Optional<Atendente> findById(Long id) {
        return atendentes.stream().filter(atendente -> atendente.getId().equals(id)).findFirst();
    }

    public Atendente save(Atendente atendente) {
        atendentes.add(atendente);
        return atendente;
    }

    public void delete(Atendente atendente) {
        atendentes.remove(atendente);
    }
}
