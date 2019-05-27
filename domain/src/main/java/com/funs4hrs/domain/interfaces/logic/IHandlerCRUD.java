package com.funs4hrs.domain.interfaces.logic;

import java.util.List;

public interface IHandlerCRUD<T,R> {

    T create(T entity);

    T read(R id);

    List<T> readAll();

    T update(T entity);

    boolean delete(R id);
}
