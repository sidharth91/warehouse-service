package com.assignment.warehouse.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryArticleUploadDTO {
    @SerializedName("art_id")
    private String id;
    private String name;
    private String stock;
}
