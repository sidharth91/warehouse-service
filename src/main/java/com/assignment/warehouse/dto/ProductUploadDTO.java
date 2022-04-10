package com.assignment.warehouse.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductUploadDTO {
    private String name;

    @SerializedName("contain_articles")
    private List<ProductArticleUploadDTO> containArticles;
}
