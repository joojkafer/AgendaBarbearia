package model.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.Barbeiro;

public class BarbeiroRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AgendaBarbearia");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Barbeiro> findAll() {
        return entityManager.createQuery("FROM Barbeiro", Barbeiro.class).getResultList();
    }

    public Optional<Barbeiro> findById(int id) {
        Barbeiro barbeiro = entityManager.find(Barbeiro.class, id);
        return barbeiro != null ? Optional.of(barbeiro) : Optional.empty();
    }

    public Barbeiro save(Barbeiro barbeiro) {
        try {
            entityManager.getTransaction().begin();
            if (barbeiro.getIdBarbeiro() == 0) {
                entityManager.persist(barbeiro);
            } else {
                entityManager.merge(barbeiro);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return barbeiro;
    }

    public void delete(Barbeiro barbeiro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(barbeiro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
