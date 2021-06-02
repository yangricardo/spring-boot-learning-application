package com.example.task.resources;

import com.example.task.models.Product;
import com.example.task.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    private ResponseEntity<?> badRequestValidationResponseEntity(Errors errors) {
        return ResponseEntity.badRequest()
                .body(
                        errors.getAllErrors().stream()
                                .map(msg->msg.getDefaultMessage())
                                .collect(Collectors.joining(","))
                );
    }

    @GetMapping
    @ResponseBody
    ResponseEntity<?> index() {
        return ResponseEntity.ok(this.productService.index());
    }

    @GetMapping("/{id}")
    @ResponseBody
    ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return this.productService.findById(id)
            .map(product -> ResponseEntity.ok(product))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code=HttpStatus.CREATED)
    ResponseEntity<?> create(@Valid  @RequestBody Product product, Errors errors) {
        if(!errors.hasErrors()) {
            Product productCreated = this.productService.create(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(productCreated);
        } else {
            return badRequestValidationResponseEntity(errors);
        }
    }

    @PatchMapping("/{id}")
    @ResponseBody
    ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Product product, Errors errors) {
        if(!errors.hasErrors()) {
           return this.productService.update(id, product)
                    .map(productUpdated -> ResponseEntity.ok(productUpdated))
                    .orElseGet(()->ResponseEntity.notFound().build());
        } else {
            return badRequestValidationResponseEntity(errors);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            this.productService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
