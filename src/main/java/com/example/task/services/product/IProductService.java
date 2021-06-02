package com.example.task.services.product;

import com.example.task.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> index();
    public Optional<Product> findById(Long id);
    public Product create(Product product);
    public Optional<Product> update(Long id, Product product);
    public void delete(Long id);
}
