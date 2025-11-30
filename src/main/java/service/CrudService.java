package main.java.service;

import java.util.List;
import java.util.Optional;

// Interface CRUD genérica para os serviços
public interface CrudService<T> {
    List<T> findAll();
    Optional<T> findById(int id);
    T create(T obj);
    boolean delete(int id);
}

