package controller;

import java.util.List;

import model.entity.ServicoAgendamento;
import model.repository.ServicoAgendamentoRepository;

public class ServicoAgendamentoController {
    private ServicoAgendamentoRepository servicoAgendamentoRepository = new ServicoAgendamentoRepository();

    public List<ServicoAgendamento> getAllServicoAgendamentos() {
        return servicoAgendamentoRepository.findAll();
    }

    public ServicoAgendamento createServicoAgendamento(ServicoAgendamento servicoAgendamento) {
        return servicoAgendamentoRepository.save(servicoAgendamento);
    }

    public ServicoAgendamento updateServicoAgendamento(int id, ServicoAgendamento servicoAgendamentoDetails) {
        ServicoAgendamento servicoAgendamento = servicoAgendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("ServicoAgendamento not found"));
        servicoAgendamento.setAgendamento(servicoAgendamentoDetails.getAgendamento());
        servicoAgendamento.setServico(servicoAgendamentoDetails.getServico());
        return servicoAgendamentoRepository.save(servicoAgendamento);
    }

    public void deleteServicoAgendamento(int id) {
        ServicoAgendamento servicoAgendamento = servicoAgendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("ServicoAgendamento not found"));
        servicoAgendamentoRepository.delete(servicoAgendamento);
    }

    public ServicoAgendamento findById(int id) {
        return servicoAgendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("ServicoAgendamento not found"));
    }
}
