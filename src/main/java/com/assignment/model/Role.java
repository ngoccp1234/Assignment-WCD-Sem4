package com.assignment.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "role")
    private List<User_Role>user_roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<User_Role> getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(List<User_Role> user_roles) {
        this.user_roles = user_roles;
    }

    public Role() {
    }

    public Role(int id, String name, String description, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Role(int id, String name, String description, int status, List<User_Role> user_roles) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.user_roles = user_roles;
    }
}
