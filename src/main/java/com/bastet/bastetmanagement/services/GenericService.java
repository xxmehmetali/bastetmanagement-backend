package com.bastet.bastetmanagement.services;

import com.bastet.bastetmanagement.models.Applicant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GenericService<T> {
    T findById(UUID id);
    Page<T> findAllPaged(Pageable pageable);

    List<T> findAll();

    boolean add(T model);

    boolean deleteById(UUID id);
}
