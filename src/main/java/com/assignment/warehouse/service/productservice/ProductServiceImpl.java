package com.assignment.warehouse.service.productservice;

import com.assignment.warehouse.datastore.InventoryDao;
import com.assignment.warehouse.datastore.ProductDao;
import com.assignment.warehouse.exception.ProductUnavailableException;
import com.assignment.warehouse.model.Article;
import com.assignment.warehouse.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productStore;

    @Autowired
    InventoryDao articleStore;


    /**
     *
     * @return All available products
     */

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

    /**
     *
     * @param id of the product which will be removed or sell
     * @return Product which is removed od sold
     */
    @Override
    public Product sellProduct(String id) {
        List<Article> articles = articleStore.findAll();
        Product product = productStore.find(id);
        Map<String, Article> articleMap = articles.stream().collect(
                Collectors.toMap(Article::getId, Function.identity()));
        if(product!=null && checkIfProductAvailable(product,articleMap)){
           product.getRequiredArticleList().stream().map(p->{
               Article ar=articleMap.get(p.getId());
               ar.setStock(ar.getStock()-p.getRequiredStock());
               return ar;
           }).map(art->articleStore.update(art)).collect(Collectors.toList());
        }else{
            throw new ProductUnavailableException("product not found OR Required product not available as inventory does not have required articles");
        }
        return product;
    }

    /**
     *
     * @param product
     * @param articleMap
     * @return true or false if product required articles is available in  inventory
     */
    private boolean checkIfProductAvailable(Product product,Map<String, Article> articleMap){
        return product.getRequiredArticleList().stream()
                .allMatch(article->articleMap.get(article.getId())!=null && article.getRequiredStock()<=articleMap.get(article.getId()).getStock());

    }

}
