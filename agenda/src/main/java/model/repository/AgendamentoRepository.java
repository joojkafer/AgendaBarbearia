package model.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.Agendamento;

public class AgendamentoRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AgendaBarbearia");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Agendamento> findAll() {
        return entityManager.createQuery("FROM Agendamento", Agendamento.class).getResultList();
    }

    public Optional<Agendamento> findById(int id) {
        Agendamento agendamento = entityManager.find(Agendamento.class, id);
        return agendamento != null ? Optional.of(agendamento) : Optional.empty();
    }

    public Agendamento save(Agendamento agendamento) {
        try {
            entityManager.getTransaction().begin();
            if (agendamento.getIdAgendamento() == 0) {
                entityManager.persist(agendamento);
            } else {
                entityManager.merge(agendamento);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return agendamento;
    }

    public void delete(Agendamento agendamento) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(agendamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
