package controller;

import java.util.List;

import model.entity.Servicos;
import model.repository.ServicoRepository;

public class ServicoController {
    private ServicoRepository servicoRepository = new ServicoRepository();

    public List<Servicos> getAllServicos() {
        return servicoRepository.findAll();
    }

    public Servicos createServico(Servicos servico) {
        return servicoRepository.save(servico);
    }

    public Servicos updateServico(int id, Servicos servicoDetails) {
        Servicos servico = servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico not found"));
        servico.setServico(servicoDetails.getServico());
        servico.setDescServico(servicoDetails.getDescServico());
        servico.setValorServico(servicoDetails.getValorServico());
        return servicoRepository.save(servico);
    }

    public void deleteServico(int id) {
        Servicos servico = servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico not found"));
        servicoRepository.delete(servico);
    }

    public Servicos findById(int id) {
        return servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico not found"));
    }
}
