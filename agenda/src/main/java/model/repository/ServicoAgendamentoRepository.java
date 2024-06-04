package model.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.ServicoAgendamento;

public class ServicoAgendamentoRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AgendaBarbearia");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<ServicoAgendamento> findAll() {
        return entityManager.createQuery("FROM ServicoAgendamento", ServicoAgendamento.class).getResultList();
    }

    public Optional<ServicoAgendamento> findById(int id) {
        ServicoAgendamento servicoAgendamento = entityManager.find(ServicoAgendamento.class, id);
        return servicoAgendamento != null ? Optional.of(servicoAgendamento) : Optional.empty();
    }

    public ServicoAgendamento save(ServicoAgendamento servicoAgendamento) {
        try {
            entityManager.getTransaction().begin();
            if (servicoAgendamento.getIdServicosAgendamento() == 0) {
                entityManager.persist(servicoAgendamento);
            } else {
                entityManager.merge(servicoAgendamento);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return servicoAgendamento;
    }

    public void delete(ServicoAgendamento servicoAgendamento) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(servicoAgendamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
