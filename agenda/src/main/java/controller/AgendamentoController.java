package controller;

import java.util.List;

import model.entity.Agendamento;
import model.repository.AgendamentoRepository;

public class AgendamentoController {
    private AgendamentoRepository agendamentoRepository = new AgendamentoRepository();

    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento createAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento updateAgendamento(Long id, Agendamento agendamentoDetails) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento not found"));
        agendamento.setCliente(agendamentoDetails.getCliente());
        // Atualize outros campos conforme necessário
        return agendamentoRepository.save(agendamento);
    }

    public void deleteAgendamento(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento not found"));
        agendamentoRepository.delete(agendamento);
    }
}
