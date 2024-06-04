package model.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.Cliente;

public class ClienteRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AgendaBarbearia");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Cliente> findAll() {
        return entityManager.createQuery("FROM Cliente", Cliente.class).getResultList();
    }

    public Optional<Cliente> findById(int id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return cliente != null ? Optional.of(cliente) : Optional.empty();
    }

    public Cliente save(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            if (cliente.getIdCliente() == 0) {
                entityManager.persist(cliente);
            } else {
                entityManager.merge(cliente);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return cliente;
    }

    public void delete(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
