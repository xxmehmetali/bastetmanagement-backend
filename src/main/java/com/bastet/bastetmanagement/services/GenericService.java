package com.bastet.bastetmanagement.services;

import com.bastet.bastetmanagement.models.Applicant;

import java.util.UUID;

public interface GenericService<T> {
    T findById(UUID id);
}
