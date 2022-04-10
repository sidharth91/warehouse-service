package com.assignment.warehouse.datastore;

import com.assignment.warehouse.model.Article;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is repository class for the Article Data
 * Class has implements the DataStore interface and defined all the abstract class
 */

@Repository
public class InventoryDao implements WareHouseRepository<String,Article> {
    private Map<String, Article> articleMap=new HashMap<>();

    @Override
    public Article save(Article data) {
        articleMap.put(data.getId(),data);
        return data;
    }

    @Override
    public List<Article> findAll() {
        return articleMap.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Article find(String id) {
        return articleMap.getOrDefault(id,null);
    }

    @Override
    public Article update(Article data) {
        articleMap.put(data.getId(),data);
        return data;
    }
}
