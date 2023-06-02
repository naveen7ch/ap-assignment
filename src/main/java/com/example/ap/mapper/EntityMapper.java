package com.example.ap.mapper;

import java.util.List;

public interface EntityMapper<D, E> {
    E toEntity(D d);

    D toDto(E e);

    List<E> toEntity(List<D> ds);

    List<D> toDto(List<E> es);
}
