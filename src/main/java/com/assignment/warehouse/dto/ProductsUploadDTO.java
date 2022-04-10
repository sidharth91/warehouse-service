package com.assignment.warehouse.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductsUploadDTO {
    List<ProductUploadDTO> products;
}
