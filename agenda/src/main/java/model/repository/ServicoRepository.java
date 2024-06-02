package model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.entity.Servicos;

public class ServicoRepository {
    private List<Servicos> servicos = new ArrayList<>();

    public List<Servicos> findAll() {
        return servicos;
    }

    public Optional<Servicos> findById(Long id) {
        return servicos.stream().filter(servico -> servico.getId().equals(id)).findFirst();
    }

    public Servicos save(Servicos servico) {
        servicos.add(servico);
        return servico;
    }

    public void delete(Servicos servico) {
        servicos.remove(servico);
    }
}
