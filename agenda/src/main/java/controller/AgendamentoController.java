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

    public Agendamento updateAgendamento(int id, Agendamento agendamentoDetails) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento not found"));
        agendamento.setDataAgendamento(agendamentoDetails.getDataAgendamento());
        agendamento.setHorario(agendamentoDetails.getHorario());
        agendamento.setBarbeiro(agendamentoDetails.getBarbeiro());
        agendamento.setCliente(agendamentoDetails.getCliente());
        return agendamentoRepository.save(agendamento);
    }

    public void deleteAgendamento(int id) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento not found"));
        agendamentoRepository.delete(agendamento);
    }

    public Agendamento findById(int id) {
        return agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento not found"));
    }
}
