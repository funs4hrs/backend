package com.funs4hrs.domain.interfaces;

public interface ICRUD<T, R> {

    T create(T entity);

    T read(R id);

    Iterable<T> readAll();

    T update(T entity);

    boolean delete(R id);
}
