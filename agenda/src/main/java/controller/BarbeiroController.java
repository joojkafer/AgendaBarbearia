package controller;

import java.util.List;

import model.entity.Barbeiro;
import model.repository.BarbeiroRepository;

public class BarbeiroController {
    private BarbeiroRepository barbeiroRepository = new BarbeiroRepository();

    public List<Barbeiro> getAllBarbeiros() {
        return barbeiroRepository.findAll();
    }

    public Barbeiro createBarbeiro(Barbeiro barbeiro) {
        return barbeiroRepository.save(barbeiro);
    }

    public Barbeiro updateBarbeiro(Long id, Barbeiro barbeiroDetails) {
        Barbeiro barbeiro = barbeiroRepository.findById(id).orElseThrow(() -> new RuntimeException("Barbeiro not found"));
        barbeiro.setNome(barbeiroDetails.getNome());
        // Atualize outros campos conforme necessário
        return barbeiroRepository.save(barbeiro);
    }

    public void deleteBarbeiro(Long id) {
        Barbeiro barbeiro = barbeiroRepository.findById(id).orElseThrow(() -> new RuntimeException("Barbeiro not found"));
        barbeiroRepository.delete(barbeiro);
    }
}
