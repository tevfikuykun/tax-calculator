package com.example.taxcalculator.repository;

import com.example.taxcalculator.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
