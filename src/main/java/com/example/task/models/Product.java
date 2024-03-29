package com.example.task.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Can not be empty")
    @NotBlank(message = "Can not be blank")
    @Size(min = 4, max = 255)
    private String name;

    @Min(value = 1)
    @Max(value = 10000)
    private Integer qtd;

    private Date createdAt;

    public Product() {}

    public Product(Long id, String name, Integer qtd, Date createdAt) {
        this.id = id;
        this.name = name;
        this.qtd = qtd;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void onPrePersist() {
        if(this.createdAt == null) {
            this.createdAt = new Date();
        }
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
