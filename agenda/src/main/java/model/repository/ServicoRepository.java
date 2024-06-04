package model.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.Servicos;

public class ServicoRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AgendaBarbearia");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Servicos> findAll() {
        return entityManager.createQuery("FROM Servicos", Servicos.class).getResultList();
    }

    public Optional<Servicos> findById(int id) {
        Servicos servico = entityManager.find(Servicos.class, id);
        return servico != null ? Optional.of(servico) : Optional.empty();
    }

    public Servicos save(Servicos servico) {
        try {
            entityManager.getTransaction().begin();
            if (servico.getIdServico() == 0) {
                entityManager.persist(servico);
            } else {
                entityManager.merge(servico);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return servico;
    }

    public void delete(Servicos servico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(servico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
