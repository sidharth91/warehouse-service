package com.assignment.warehouse.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *This interface will be implemented while parsing a json file and processing the data
 * @param <T> type of object to be parsed from file
 * @param <K> type of object to be returned after processing
 */

public interface FileDeserializeService<T,K> {
	public List<K> deserializeFile(MultipartFile file) ;

}