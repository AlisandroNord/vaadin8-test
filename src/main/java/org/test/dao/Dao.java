package org.test.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {
    public T findById(ID id);
    public void save(T entity);
    public void update(T entity);
    public void delete(T entity);
    public List<T> findAll();
}
