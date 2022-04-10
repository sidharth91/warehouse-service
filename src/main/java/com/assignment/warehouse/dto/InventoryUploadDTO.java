package com.assignment.warehouse.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InventoryUploadDTO {
    @SerializedName("inventory")
private List<InventoryArticleUploadDTO> articles;
}
