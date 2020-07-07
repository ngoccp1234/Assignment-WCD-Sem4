package com.assignment.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;


    @Column(name = "category_id")
    private int category_id;

    @ManyToOne()
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "product_attribute",
joinColumns = @JoinColumn(name = "product_id"),
inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private List<Attribute> attributes;


    public Product(int id, String name, String image, int price, int quantity, String description, int status, int category_id, Category category, List<Attribute> attributes) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.category_id = category_id;
        this.category = category;
        this.attributes = attributes;
    }

    public Product(int id, String name, String image, int price, int quantity, String description, int status, int categoryId, List<Attribute> list) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.price = price;
    this.quantity = quantity;
    this.description = description;
    this.status = status;
    this.category_id = categoryId;
    this.attributes = list;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Attribute> getAttribute() {
        return attributes;
    }

    public void setAttribute(List<Attribute> attribute) {
        this.attributes = attribute;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Product(int id, String name, String image, int price, String description, int status, int category_id, Category category, List<Attribute> attributes) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.status = status;
        this.category_id = category_id;
        this.category = category;
        this.attributes = attributes;
    }

    public Product(int id, String name, String image, int price, String description, int status, int category_id) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.status = status;
        this.category_id = category_id;
    }

    public Product(int id, String name, String image, int price, String description, int status, int category_id, List<Attribute> attributes) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.status = status;
        this.category_id = category_id;
        this.attributes = attributes;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(String name, String image, int price, String description, int status, int category_id) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.status = status;
        this.category_id = category_id;
    }

    public Product() {
    }

    public Product(int id, String name, String image, int price, String description, int status, int category_id, Category category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.status = status;
        this.category_id = category_id;
        this.category = category;
    }
}

