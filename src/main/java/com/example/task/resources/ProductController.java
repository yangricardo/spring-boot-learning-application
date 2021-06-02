package com.example.task.resources;

import com.example.task.models.Product;
import com.example.task.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseBody
    List<Product> index() {
        return this.productService.index();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Optional<Product> findById(@PathVariable("id") Long id, HttpServletResponse response) {
        Optional<Product> product = this.productService.findById(id);
        if(product.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        return product;
    }

    @PostMapping
    @ResponseBody
    Product create(@RequestBody Product product, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_CREATED);
        return this.productService.create(product);
    }

    @PatchMapping("/{id}")
    @ResponseBody
    Optional<Product> update(@PathVariable("id") Long id, @RequestBody Product product, HttpServletResponse response) {
        Optional<Product> productUpdated = this.productService.update(id, product);
        if(productUpdated.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        return productUpdated;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    void delete(@PathVariable("id") Long id, HttpServletResponse response) {
        try {
            this.productService.delete(id);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
