package com.example.springboot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.models.ProductJson;

@RestController
@RequestMapping("productsjson")
public class ProductJsonController {
    @GetMapping("/all")
    public ProductJson products(@PathVariable("product") String product) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductJson> resp = restTemplate.getForEntity(
                String.format("https://dummyjson.com/products"),
                ProductJson.class);
        return resp.getBody();
    }

    @GetMapping("{product}")
    public ProductJson product(@PathVariable("product") String product) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductJson> resp = restTemplate.getForEntity(
                String.format("https://dummyjson.com/products/%s", product),
                ProductJson.class);
        return resp.getBody();
    }
}