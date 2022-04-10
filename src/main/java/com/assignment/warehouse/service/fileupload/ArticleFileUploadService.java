package com.assignment.warehouse.service.fileupload;

import com.assignment.warehouse.datastore.InventoryDao;
import com.assignment.warehouse.dto.InventoryUploadDTO;
import com.assignment.warehouse.model.Article;
import com.assignment.warehouse.util.WareHouseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * This class defined the processData method for which will be executed after file is deserialized
 *
 */
@Service
public class ArticleFileUploadService extends BaseFileDeserializeService<InventoryUploadDTO,Article> {

    @Autowired
    InventoryDao articleStore;

    /**
     *
     * @param data the parsed object from the file
     * @return List of Article object which got processed
     */

    @Override
    protected List<Article> processData(InventoryUploadDTO data) {
        return data.getArticles().stream().map(t-> WareHouseUtility.convertDtoToArticle(t))
                .map(p-> articleStore.save(p)).collect(Collectors.toList());
    }
}
