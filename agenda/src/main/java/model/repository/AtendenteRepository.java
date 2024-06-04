package model.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.Atendente;

public class AtendenteRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AgendaBarbearia");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Atendente> findAll() {
        return entityManager.createQuery("FROM Atendente", Atendente.class).getResultList();
    }

    public Optional<Atendente> findById(int id) {
        Atendente atendente = entityManager.find(Atendente.class, id);
        return atendente != null ? Optional.of(atendente) : Optional.empty();
    }

    public Atendente save(Atendente atendente) {
        try {
            entityManager.getTransaction().begin();
            if (atendente.getIdAtendente() == 0) {
                entityManager.persist(atendente);
            } else {
                entityManager.merge(atendente);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return atendente;
    }

    public void delete(Atendente atendente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(atendente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
