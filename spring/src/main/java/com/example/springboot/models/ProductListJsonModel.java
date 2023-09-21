package com.example.springboot.models;

import java.util.List;

public class ProductListJsonModel {
    private List<ProductJsonModel> products;
    private int total;
    private int skip;
    private int limit;
    
    public List<ProductJsonModel> getProducts() {
        return products;
    }
    public void setProducts(List<ProductJsonModel> products) {
        this.products = products;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getSkip() {
        return skip;
    }
    public void setSkip(int skip) {
        this.skip = skip;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

    
}
