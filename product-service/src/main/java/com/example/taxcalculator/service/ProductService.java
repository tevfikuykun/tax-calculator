package com.example.taxcalculator.service;

import com.example.taxcalculator.model.Product;
import com.example.taxcalculator.model.User;
import com.example.taxcalculator.repository.ProductRepository;
import com.example.taxcalculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    // Create product and link it to the logged-in user (owner)
    public Product createProduct(Product product, Long userId) {
        // Find user by userId
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            product.setOwner(user.get());  // Link product to the owner
            return productRepository.save(product);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Update product (only if the user is the owner)
    public Product updateProduct(Long productId, Product updatedProduct, Long userId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (!productOpt.isPresent()) {
            throw new RuntimeException("Product not found");
        }

        Product product = productOpt.get();
        if (!product.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized to modify this product");
        }

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setTaxRate(updatedProduct.getTaxRate());

        return productRepository.save(product);
    }

    // Delete product (only if the user is the owner)
    public void deleteProduct(Long productId, Long userId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (!productOpt.isPresent()) {
            throw new RuntimeException("Product not found");
        }

        Product product = productOpt.get();
        if (!product.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized to delete this product");
        }

        productRepository.deleteById(productId);
    }

    // Calculate the tax for a given product
    public BigDecimal calculateTax(Product product) {
        if (product.getTaxRate() == null) {
            throw new RuntimeException("Tax rate not set for this product");
        }
        return product.getPrice().multiply(product.getTaxRate());
    }
}
