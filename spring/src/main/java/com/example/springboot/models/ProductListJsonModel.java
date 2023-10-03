package com.example.springboot.models;

import java.util.List;

import lombok.Data;
@Data
public class ProductListJsonModel {
    private List<ProductJsonModel> products;
    private int total;
    private int skip;
    private int limit;
    
}
