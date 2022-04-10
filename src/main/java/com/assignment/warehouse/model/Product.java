package com.assignment.warehouse.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;
/**
 * This class is the Product Entity class
 */

@Data
@Builder
public class Product {
    private String id;
    private String name;
    private List<RequiredArticle> requiredArticleList;

}
