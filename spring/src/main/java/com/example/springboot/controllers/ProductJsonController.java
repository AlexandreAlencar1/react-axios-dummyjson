package com.example.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.models.ProductJsonModel;
import com.example.springboot.models.ProductListJsonModel;
import com.example.springboot.services.ProductJsonService;

@RestController
@RequestMapping("productsjson")
public class ProductJsonController {

    private final ProductJsonService productJsonService;

    @Autowired
    public ProductJsonController(ProductJsonService productJsonService) {
        this.productJsonService = productJsonService;

        // Ao criar uma instância do controlador, chame o método para salvar a lista de
        // produtos, tirei o post na url save para rodar automaticametne
        this.productJsonService.saveProductListFromExternalAPI();
    }

    @PostMapping("save")
    public ResponseEntity<String> saveProductList() {
        return ResponseEntity.ok("Product list saved successfully!");
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductJsonModel> product(@PathVariable("productId") Long productId) {
        ProductJsonModel product = productJsonService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("listFromDB")
    public ProductListJsonModel productListFromDB() {
        return productJsonService.getAllProducts();
    }
}
