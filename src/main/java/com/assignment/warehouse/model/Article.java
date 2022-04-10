package com.assignment.warehouse.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

/**
 * This class is the Article Entity class
 */

@Data
@Builder
public class Article{
   @SerializedName("art_id")
    private String id;
    private String name;
    private int stock;
}
