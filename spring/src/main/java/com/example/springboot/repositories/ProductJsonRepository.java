package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.models.ProductJsonModel;

@Repository
public interface ProductJsonRepository extends JpaRepository <ProductJsonModel, Long> {
    
}
