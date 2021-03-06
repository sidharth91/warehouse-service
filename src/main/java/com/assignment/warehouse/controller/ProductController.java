package com.assignment.warehouse.controller;


import com.assignment.warehouse.dto.BuyProductDTO;
import com.assignment.warehouse.model.Product;
import com.assignment.warehouse.service.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    ProductService productService;

    @GetMapping("/v1/products")
    public ResponseEntity<List<Product>> fetchAllProduct()
    {
        return ResponseEntity.ok(productService.findAllAvailableProducts());
    }

    @PostMapping("/v1/product/sell")
    public ResponseEntity<Product> sellProduct(@RequestBody BuyProductDTO dto)
    {
        return ResponseEntity.ok(productService.sellProduct(dto.getId()));
    }
}
