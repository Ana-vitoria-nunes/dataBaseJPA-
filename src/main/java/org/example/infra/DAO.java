package org.example.infra;
import org.example.model.ProdutoModel;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class DAO {
    public void addPerson(ProdutoModel produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(produto);
            entityTransaction.commit();
        } catch (Exception exception) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            exception.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public Optional<ProdutoModel> findPersonById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return Optional.ofNullable(entityManager.find(ProdutoModel.class, id));
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    public List<ProdutoModel> getAllPerson() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<ProdutoModel> query = entityManager.createQuery("SELECT p FROM Person p", ProdutoModel.class);
            return query.getResultList();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
    public void updateProduto(ProdutoModel produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(produto);
            entityTransaction.commit();
        } catch (Exception exception) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            exception.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}