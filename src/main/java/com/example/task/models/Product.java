package com.example.task.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer qtd;

    private Date createdAt;

    public Product() {}

    public Product(Long id, String name, Integer qtd, Date createdAt) {
        this.id = id;
        this.name = name;
        this.qtd = qtd;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
