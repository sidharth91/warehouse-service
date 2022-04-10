package com.assignment.warehouse.service;

import com.assignment.warehouse.datastore.ArticleStore;
import com.assignment.warehouse.datastore.ProductStore;
import com.assignment.warehouse.model.Article;
import com.assignment.warehouse.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductStore productStore;

    @Autowired
    ArticleStore articleStore;


    @Override
    public List<Product> findAllAvailableProducts() {
        List<Product> result=new ArrayList<>();
        List<Article> articles = articleStore.findAll();
        List<Product> producs = productStore.findAll();
        Map<String, Article> articleMap = articles.stream().collect(
                Collectors.toMap(Article::getId, Function.identity()));
        result=producs.stream().filter(p->checkIfProductAvailable(p,articleMap)).collect(Collectors.toList());
        return result;

    }

    @Override
    public Product sellProduct(String id) {
        List<Article> articles = articleStore.findAll();
        Product product = productStore.find(id);
        Map<String, Article> articleMap = articles.stream().collect(
                Collectors.toMap(Article::getId, Function.identity()));
        if(checkIfProductAvailable(product,articleMap)){
           product.getRequiredArticleList().stream().map(p->{
               Article ar=articleMap.get(p.getId());
               ar.setStock(ar.getStock()-p.getRequiredStock());
               return ar;
           }).map(art->articleStore.update(art)).collect(Collectors.toList());
        }
        return product;
    }

    private boolean checkIfProductAvailable(Product product,Map<String, Article> articleMap){
        return product.getRequiredArticleList().stream()
                .allMatch(p->articleMap.get(p.getId())!=null && p.getRequiredStock()<=articleMap.get(p.getId()).getStock());

    }

}
