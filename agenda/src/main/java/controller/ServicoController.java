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

    public Servicos updateServico(Long id, Servicos servicoDetails) {
        Servicos servico = servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico not found"));
        servico.setName(servicoDetails.getName());
        // Atualize outros campos conforme necessário
        return servicoRepository.save(servico);
    }

    public void deleteServico(Long id) {
        Servicos servico = servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico not found"));
        servicoRepository.delete(servico);
    }
}
