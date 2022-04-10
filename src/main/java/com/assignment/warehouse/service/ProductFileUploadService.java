package com.assignment.warehouse.service;

import com.assignment.warehouse.datastore.ProductStore;
import com.assignment.warehouse.dto.InventoryUploadDTO;
import com.assignment.warehouse.dto.ProductsUploadDTO;
import com.assignment.warehouse.model.Article;
import com.assignment.warehouse.model.Product;
import com.assignment.warehouse.util.WareHouseUtility;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductFileUploadService extends BaseFileDeserializeService<ProductsUploadDTO, Product>{

    @Autowired
    ProductStore proStore;

    @Override
    protected List<Product> processData(ProductsUploadDTO data) {
        return data.getProducts().stream().map(t-> WareHouseUtility.convertDtoToProduct(t))
                .map(p-> proStore.save(p)).collect(Collectors.toList());
    }
}
