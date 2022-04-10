package com.assignment.warehouse.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


/**
 * This is the abstract implementation of the FileDeserializeService
 * deserializeFile method is defined but processData is kept abstract .
 * processData methos has tobe implemented by child class
 * @param <T> type of object to be parsed from file
 * @param <K> type of object to be returned after processing
 */


public abstract class BaseFileDeserializeService<T,K> implements  FileDeserializeService<T,K>{

    /**
     *
     * @param file to be parsed
     * @return List ok K type object after processing
     */
    @Override
    public List<K> deserializeFile(MultipartFile file) {
        Gson gson = new Gson();
        T data =null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            Type collectionType = new TypeToken<T>(){}.getType();
            Type type = ((ParameterizedType) ClassUtils.getUserClass(this).getGenericSuperclass())
                    .getActualTypeArguments()[0];
             data = gson.fromJson(reader, type);

        }catch (IOException e) {
            e.printStackTrace();
        }
        return processData(data);
    }


    /**
     *
     * @param data the parsed object from the file
     * @return  List ok K type object after processing
     */
    protected abstract List<K> processData(T data);
}
