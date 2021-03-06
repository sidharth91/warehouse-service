package com.assignment.warehouse.datastore;

import com.assignment.warehouse.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is repository class for the Product Data
 * Class has implements the DataStore interface and defined all the abstract class
 */

@Repository
public class ProductDao implements WareHouseRepository<String,Product> {
    private Map<String, Product> productMap =new HashMap<>();

    /**
     * this set is only used for to check unique name of the product
     */
    private Set<String> productName= new HashSet<>();

    @Override
    public Product save(Product data) {
        if(productName.add(data.getName())) {
            productMap.put(data.getId(), data);
        }
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
