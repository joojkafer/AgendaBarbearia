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

    public Atendente updateAtendente(int id, Atendente atendenteDetails) {
        Atendente atendente = atendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendente not found"));
        atendente.setNome(atendenteDetails.getNome());
        atendente.setCpf(atendenteDetails.getCpf());
        atendente.setUserLogin(atendenteDetails.getUserLogin());
        atendente.setUserPassword(atendenteDetails.getUserPassword());
        return atendenteRepository.save(atendente);
    }

    public void deleteAtendente(int id) {
        Atendente atendente = atendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendente not found"));
        atendenteRepository.delete(atendente);
    }

    public Atendente findById(int id) {
        return atendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendente not found"));
    }
}
