package com.assignment.warehouse.controller;

import com.assignment.warehouse.service.ArticleFileUploadService;
import com.assignment.warehouse.service.ProductFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    ArticleFileUploadService articlFileUploadService;

    @Autowired
    ProductFileUploadService prodFileUploadService;

    @PostMapping("/v1/articles")
    public ResponseEntity<String> uploadArticles(@RequestParam("file") MultipartFile file)
    {
        articlFileUploadService.deserializeFile(file);
        return ResponseEntity.ok("File uploaded successfully");
    }

    @PostMapping("/v1/products/upload")
    public ResponseEntity<String> uploadProducts(@RequestParam("file") MultipartFile file)
    {
        prodFileUploadService.deserializeFile(file);
        return ResponseEntity.ok("File uploaded successfully");
    }
}
