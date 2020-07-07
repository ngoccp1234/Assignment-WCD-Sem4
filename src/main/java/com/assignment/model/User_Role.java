package com.assignment.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class User_Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "roleId")
    private int roleId;

    @Column(name = "userId")
    private int userId;

    @ManyToOne()
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private Role role;

    @ManyToOne()
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    public User_Role(int id, int roleId, int userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }


    public User_Role(int roleId, int userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public User_Role(int id, int roleId, int userId, Role role, User user) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
        this.role = role;
        this.user = user;
    }

    public User_Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
