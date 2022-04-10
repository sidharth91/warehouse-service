package com.assignment.warehouse.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductArticleUploadDTO {
    @SerializedName("art_id")
    private String artid;
    @SerializedName("amount_of")
    private String amountOf;

}

