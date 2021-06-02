package com.example.task.resources;

import com.example.task.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    @ResponseBody
    List<Product> index() {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseBody
    Product findById(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping
    @ResponseBody
    Product create(@RequestBody Product product) {
        return  null;
    }

    @PutMapping("/{id}")
    @ResponseBody
    Product update(@PathVariable("id") Long id, @RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    void delete(@PathVariable("id") Long id) {
        return;
    }
}
