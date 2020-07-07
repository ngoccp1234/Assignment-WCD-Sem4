package com.assignment.dao;

import com.assignment.model.Attribute;
import com.assignment.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public List<Attribute> getAllAttribute() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Attribute> list = em.createQuery("SELECT c FROM Attribute c", Attribute.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public void insertProduct(Product product) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public List<Product> getAllProduct() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> list = em.createQuery("SELECT c FROM Product c WHERE status = 1", Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public Product getProduct(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();
        em.close();
        return product;
    }

    public Attribute getAttribute(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Attribute attribute = em.find(Attribute.class, id);
        em.getTransaction().commit();
        em.close();
        return attribute;
    }
    public void updateProduct(Product product) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product1 = em.find(Product.class, product.getId());
        product1.setName(product.getName());
        product1.setImage(product.getImage());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        product1.setDescription(product.getDescription());
        product1.setStatus(product.getStatus());
        product1.setCategory_id(product.getCategory_id());
        product1.setAttributes(product.getAttributes());
        em.getTransaction().commit();
        em.close();
    }

    public void deleteProduct(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        product.setStatus(3);
        em.getTransaction().commit();
        em.close();
    }
}
