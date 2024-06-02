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

    public ServicoAgendamento updateServicoAgendamento(Long id, ServicoAgendamento servicoAgendamentoDetails) {
        ServicoAgendamento servicoAgendamento = servicoAgendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("ServicoAgendamento not found"));
        servicoAgendamento.setServicos(servicoAgendamentoDetails.getServicos());
        // Atualize outros campos conforme necessário
        return servicoAgendamentoRepository.save(servicoAgendamento);
    }

    public void deleteServicoAgendamento(Long id) {
        ServicoAgendamento servicoAgendamento = servicoAgendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("ServicoAgendamento not found"));
        servicoAgendamentoRepository.delete(servicoAgendamento);
    }
}
