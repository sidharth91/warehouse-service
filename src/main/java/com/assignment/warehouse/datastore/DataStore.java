package com.assignment.warehouse.datastore;

import java.util.List;

/**
 * This interface has to be implemented by repository classes and provide the defination for all the abstract methods
 * @param <K> ID type of the object
 * @param <T> Object
 */
public interface DataStore<K,T> {
    public T save(T data);
    public List<T> findAll();
    public T find(K id);
    public T update(T data);
}
