package com.assignment.dao;

import com.assignment.model.Category;
import com.assignment.model.Product;
import com.assignment.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RoleDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public void insertRole(Role role) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();
        em.close();
    }


    public List<Role> getAllRole() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Role> list = em.createQuery("SELECT c FROM Role c WHERE c.status = 1", Role.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }


    public void deleteRole(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Role role = em.find(Role.class, id);
        role.setStatus(3);
        em.getTransaction().commit();
        em.close();
    }

    public void updateRole(Role role) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Role role1 = em.find(Role.class, role.getId());
        role1.setName(role.getName());
        role1.setDescription(role.getDescription());
        role1.setStatus(role.getStatus());
        em.getTransaction().commit();
        em.close();
    }

    public Role getRole(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Role role = em.find(Role.class, id);
        em.getTransaction().commit();
        em.close();
        return role;
    }

    public Role getRoleforName(String name) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Role role = em.createQuery("select u from Role u where u.name = '" + name + "'", Role.class).getSingleResult();
        em.persist(role);
        em.getTransaction().commit();
        em.close();
        return role;
    }
}
