package com.example.springboot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.models.ProductJsonModel;

@RestController
@RequestMapping("productsjson")
public class ProductJsonController {

    @GetMapping("{product}")
    public ProductJsonModel product(@PathVariable("product") String product) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductJsonModel> resp = restTemplate.getForEntity(
                String.format("https://dummyjson.com/products/%s", product),
                ProductJsonModel.class);
        return resp.getBody();
    }
}