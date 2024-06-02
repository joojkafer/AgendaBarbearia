package model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.entity.Agendamento;

public class AgendamentoRepository {
    private List<Agendamento> agendamentos = new ArrayList<>();

    public List<Agendamento> findAll() {
        return agendamentos;
    }

    public Optional<Agendamento> findById(Long id) {
        return agendamentos.stream().filter(agendamento -> agendamento.getId().equals(id)).findFirst();
    }

    public Agendamento save(Agendamento agendamento) {
        agendamentos.add(agendamento);
        return agendamento;
    }

    public void delete(Agendamento agendamento) {
        agendamentos.remove(agendamento);
    }
}
