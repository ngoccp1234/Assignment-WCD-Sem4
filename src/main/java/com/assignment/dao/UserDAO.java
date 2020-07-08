package com.assignment.dao;

import com.assignment.model.Attribute;
import com.assignment.model.Role;
import com.assignment.model.User;
import com.assignment.model.User_Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public User doLogin(String email) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.createQuery("select u from User u where u.email = '" + email +"'", User.class).getSingleResult();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    public void insertUser(User user) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
//
    public void insertUserRole(User_Role user_role) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user_role);
        em.getTransaction().commit();
        em.close();
    }

//    public User_Role getUserRole(int id) {
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        User_Role user_role = em.find(User_Role.class, id);
//        em.getTransaction().commit();
//        em.close();
//        return user_role;
//    }

    public List<User> getAllUser() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<User> list = em.createQuery("SELECT c FROM User c WHERE c.status = 1", User.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }


    public void deleteUser(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        user.setStatus(3);
        em.getTransaction().commit();
        em.close();
    }

    public void updateUser(User user) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        User user1 = em.find(User.class, user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setStatus(user.getStatus());
        em.getTransaction().commit();
        em.close();
    }

//    public void updateUserRole(User_Role user_role) {
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        User_Role userRole = em.find(User_Role.class, user_role.getId());
//        userRole.setRoleId(user_role.getRole().getId());
//        userRole.setUserId(user_role.getUser().getId());
//        em.getTransaction().commit();
//        em.close();
//    }

//    public User_Role getUserRole(int id) {
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        User_Role user_role = em.find(User_Role.class, id);
//        em.getTransaction().commit();
//        em.close();
//        return user_role;
//    }

    public User getUser(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        em.close();
        return user;
    }
}
