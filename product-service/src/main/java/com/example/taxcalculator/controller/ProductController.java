package com.example.taxcalculator.controller;

import com.example.taxcalculator.model.Product;
import com.example.taxcalculator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Product creation with userId (owner)
    @PostMapping
    public Product createProduct(@RequestBody Product product, @RequestParam Long userId) {
        return productService.createProduct(product, userId);  // Pass owner ID (userId) to the service
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct, @RequestParam Long userId) {
        return productService.updateProduct(id, updatedProduct, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id, @RequestParam Long userId) {
        productService.deleteProduct(id, userId);
    }

    @GetMapping("/{id}/tax")
    public BigDecimal calculateTax(@PathVariable Long id) {
        Product product = productService.getAllProducts().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
        return productService.calculateTax(product);
    }
}
