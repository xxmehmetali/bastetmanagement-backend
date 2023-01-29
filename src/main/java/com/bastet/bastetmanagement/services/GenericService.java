package com.bastet.bastetmanagement.services;

import com.bastet.bastetmanagement.models.Applicant;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface GenericService<T> {
    T findById(UUID id);
//    Page<T> findApplicantsPaged(int page, int size);
//    Page<T> findApplicantsPaged(int page, int size);

}
