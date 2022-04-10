package com.assignment.warehouse.service.productservice;

import com.assignment.warehouse.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAllAvailableProducts();
    public Product sellProduct(String id);
}
