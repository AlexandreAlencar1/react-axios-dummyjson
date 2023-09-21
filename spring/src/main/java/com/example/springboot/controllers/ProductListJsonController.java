package com.example.springboot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.models.ProductListJsonModel;

@RestController
@RequestMapping("productsjson")
public class ProductListJsonController {

    @GetMapping("list")
    public ProductListJsonModel productList() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductListJsonModel> resp = restTemplate.getForEntity(
                "https://dummyjson.com/products", // Endpoint for the list of products
                ProductListJsonModel.class);
        return resp.getBody();
    }
}
