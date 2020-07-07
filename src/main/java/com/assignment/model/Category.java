package com.assignment.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(int id, String name, String image, String description, int status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Category(int id, String name, String image, String description, int status, List<Product> products) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.status = status;
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category() {
    }

    public Category(int id, String name, String image, int status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
    }

    public Category(int id, String name, String image, int status, List<Product> products) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
        this.products = products;
    }
}
