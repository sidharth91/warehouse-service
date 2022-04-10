package com.assignment.warehouse.datastore;

import com.assignment.warehouse.model.Article;
import com.assignment.warehouse.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is repository class for the Product Data
 * Class has implements the DataStore interface and defined all the abstract class
 */

@Repository
public class ProductStore implements DataStore<String,Product> {
    private Map<String, Product> productMap =new HashMap<>();

    @Override
    public Product save(Product data) {
        productMap.put(data.getId(),data);
        return data;
    }

    @Override
    public List<Product> findAll() {
        return productMap.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Product find(String id) {
        return productMap.getOrDefault(id,null);
    }

    @Override
    public Product update(Product data) {
        productMap.put(data.getId(),data);
        return data;
    }
}
