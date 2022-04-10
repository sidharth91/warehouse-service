package com.assignment.warehouse.model;

import lombok.Builder;
import lombok.Data;

/**
 * This class is the Article Required  Entity class used in Product Entity
 */

@Data
@Builder
public class RequiredArticle {
    private String id;
    private int requiredStock;
}
