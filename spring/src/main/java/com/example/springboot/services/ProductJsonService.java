package com.example.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.models.ProductJsonModel;
import com.example.springboot.models.ProductListJsonModel;
import com.example.springboot.repositories.ProductJsonRepository;

@Service
public class ProductJsonService {

    private final ProductJsonRepository productJsonRepository;

    @Autowired
    public ProductJsonService(ProductJsonRepository productJsonRepository) {
        this.productJsonRepository = productJsonRepository;
    }

    public void saveProductListFromExternalAPI() {
        RestTemplate restTemplate = new RestTemplate();
        ProductListJsonModel productList = restTemplate.getForObject(
                "https://dummyjson.com/products",
                ProductListJsonModel.class);

        if (productList != null && productList.getProducts() != null) {
            for (ProductJsonModel product : productList.getProducts()) {
                productJsonRepository.save(product);
            }
        }
    }

    public ProductJsonModel getProductById(Long productId) {
        return productJsonRepository.findById(productId).orElse(null);
    }

    public ProductListJsonModel getAllProducts() {
        Iterable<ProductJsonModel> productIterable = productJsonRepository.findAll();
        ProductListJsonModel productList = new ProductListJsonModel();
        productList.setProducts((List<ProductJsonModel>) productIterable);
        productList.setTotal((int) productJsonRepository.count());
        return productList;
    }
}
