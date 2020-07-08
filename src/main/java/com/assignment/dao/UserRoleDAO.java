package com.assignment.dao;

import com.assignment.model.User_Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRoleDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public User_Role getUserRole(int userid) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        User_Role user_role = em.createQuery("select u from User_Role u where u.userId = '" + userid + "'", User_Role.class).getSingleResult();
        em.persist(user_role);
        em.getTransaction().commit();
        em.close();
        return user_role;
    }
}
