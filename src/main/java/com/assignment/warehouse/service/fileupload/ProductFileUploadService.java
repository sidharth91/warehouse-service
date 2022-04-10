package com.assignment.warehouse.service.fileupload;

import com.assignment.warehouse.datastore.ProductDao;
import com.assignment.warehouse.dto.ProductsUploadDTO;
import com.assignment.warehouse.model.Product;
import com.assignment.warehouse.util.WareHouseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductFileUploadService extends BaseFileDeserializeService<ProductsUploadDTO, Product>{

    @Autowired
    ProductDao proStore;

    @Override
    protected List<Product> processData(ProductsUploadDTO data) {
        return data.getProducts().stream().map(t-> WareHouseUtility.convertDtoToProduct(t))
                .map(p-> proStore.save(p)).collect(Collectors.toList());
    }
}
