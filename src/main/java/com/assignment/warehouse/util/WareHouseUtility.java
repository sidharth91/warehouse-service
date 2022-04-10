package com.assignment.warehouse.util;

import com.assignment.warehouse.dto.InventoryArticleUploadDTO;
import com.assignment.warehouse.dto.ProductArticleUploadDTO;
import com.assignment.warehouse.dto.ProductUploadDTO;
import com.assignment.warehouse.model.Article;
import com.assignment.warehouse.model.Product;
import com.assignment.warehouse.model.RequiredArticle;

import java.util.UUID;
import java.util.stream.Collectors;

public class WareHouseUtility {
    /**
     *
     * @param data
     * @return Article
     */
    public static Article convertDtoToArticle(InventoryArticleUploadDTO data){
        return Article.builder().id(data.getId()).name(data.getName()).stock(Integer.parseInt(data.getStock())).build();
    }

    /**
     *
     * @param data
     * @return Product
     */
    public static Product convertDtoToProduct(ProductUploadDTO data){
        return Product.builder().id(UUID.randomUUID().toString()).name(data.getName()).requiredArticleList(data.getContainArticles().stream().map(p->convertDtoToRequiredArticle(p)).collect(Collectors.toList())).build();
    }

    /**
     *
     * @param data
     * @return RequiredArticle
     */

    public static RequiredArticle convertDtoToRequiredArticle(ProductArticleUploadDTO data){
        return RequiredArticle.builder().id(data.getArtid()).requiredStock(Integer.parseInt(data.getAmountOf())).build();
    }
}
