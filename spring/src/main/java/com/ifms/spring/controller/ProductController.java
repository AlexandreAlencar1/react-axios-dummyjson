package com.ifms.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ifms.spring.model.Product;

@RestController
@RequestMapping("consulta-products")

public class ProductController {

    @GetMapping("{products}")
    public Product product(@PathVariable("product") String product) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> resp = restTemplate.getForEntity(
                String.format("https://dummyjson.com/products/%s", product),
                Product.class);
        return resp.getBody();
    }
//-------------------------------------------------------------------------------------
    @GetMapping("/get-external-data/{product}")
    public ResponseEntity<Product> getExternalProductData(@PathVariable("product") String product) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> resp = restTemplate.getForEntity(
                String.format("https://dummyjson.com/products/%s", product),
                Product.class);

        Product productData = resp.getBody();

        return ResponseEntity.ok(productData);
    }

}
