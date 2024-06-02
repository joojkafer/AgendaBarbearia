package model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.entity.ServicoAgendamento;

public class ServicoAgendamentoRepository {
    private List<ServicoAgendamento> servicoAgendamentos = new ArrayList<>();

    public List<ServicoAgendamento> findAll() {
        return servicoAgendamentos;
    }

    public Optional<ServicoAgendamento> findById(Long id) {
        return servicoAgendamentos.stream().filter(servicoAgendamento -> servicoAgendamento.getId().equals(id)).findFirst();
    }

    public ServicoAgendamento save(ServicoAgendamento servicoAgendamento) {
        servicoAgendamentos.add(servicoAgendamento);
        return servicoAgendamento;
    }

    public void delete(ServicoAgendamento servicoAgendamento) {
        servicoAgendamentos.remove(servicoAgendamento);
    }
}
