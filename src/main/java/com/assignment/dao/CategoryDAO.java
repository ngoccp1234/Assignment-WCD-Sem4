package com.assignment.dao;

import com.assignment.model.Category;
import com.assignment.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CategoryDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public List<Product> getProductsByCategory(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> list = em.createQuery("SELECT c FROM Product c WHERE c.category_id = " + id + " and c.status = 1", Product.class)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }


    public void deleteCategory(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category = em.find(Category.class, id);
        category.setStatus(3);
        em.getTransaction().commit();
        em.close();
    }

    public void updateCategory(Category ct) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category1 = em.find(Category.class, ct.getId());
        category1.setName(ct.getName());
        category1.setImage(ct.getImage());
        category1.setDescription(ct.getDescription());
        category1.setStatus(ct.getStatus());
        em.getTransaction().commit();
        em.close();
    }

    public Category getCategory(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category = em.find(Category.class, id);
        em.getTransaction().commit();
        em.close();
        return category;
    }

    public void insertCategory(Category category) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        em.close();
    }

    public List<Category> getAllCategory() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
//        List<Category> list = em.createQuery("SELECT c FROM Category c WHERE c.status = 1", Category.class).getResultList();
        List<Category> list = em.createQuery("SELECT c FROM Category c WHERE c.status = 1", Category.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }
}
