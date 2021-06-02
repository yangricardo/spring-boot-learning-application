package com.example.task.services.product;

import com.example.task.models.Product;
import com.example.task.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> index() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product create(Product product) {
        product.setCreatedAt(new Date());
        return this.productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return this.productRepository.findById(id).map(record->{
            record.setName(product.getName());
            record.setQtd(product.getQtd());
            return this.productRepository.save(record);
        });
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
