package model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.entity.Barbeiro;

public class BarbeiroRepository {
    private List<Barbeiro> barbeiros = new ArrayList<>();

    public List<Barbeiro> findAll() {
        return barbeiros;
    }

    public Optional<Barbeiro> findById(Long id) {
        return barbeiros.stream().filter(barbeiro -> barbeiro.getId().equals(id)).findFirst();
    }

    public Barbeiro save(Barbeiro barbeiro) {
        barbeiros.add(barbeiro);
        return barbeiro;
    }

    public void delete(Barbeiro barbeiro) {
        barbeiros.remove(barbeiro);
    }
}
