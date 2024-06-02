package controller;

import java.util.List;

import model.entity.Atendente;
import model.repository.AtendenteRepository;

public class AtendenteController {
    private AtendenteRepository atendenteRepository = new AtendenteRepository();

    public List<Atendente> getAllAtendentes() {
        return atendenteRepository.findAll();
    }

    public Atendente createAtendente(Atendente atendente) {
        return atendenteRepository.save(atendente);
    }

    public Atendente updateAtendente(Long id, Atendente atendenteDetails) {
        Atendente atendente = atendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendente not found"));
        atendente.setNome(atendenteDetails.getNome());
        // Atualize outros campos conforme necessário
        return atendenteRepository.save(atendente);
    }

    public void deleteAtendente(Long id) {
        Atendente atendente = atendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendente not found"));
        atendenteRepository.delete(atendente);
    }
}
