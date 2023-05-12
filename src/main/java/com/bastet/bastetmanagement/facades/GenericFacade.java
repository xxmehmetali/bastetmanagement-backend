package com.bastet.bastetmanagement.facades;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.models.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GenericFacade<T> {
//    T findById(UUID id);
//    T findByIdSimplified(UUID id);
//    Page<? extends Dto> findApplicantsPaged(Pageable pageable);
    T findById(UUID id);
    T findByIdSimplified(UUID id);
    Page<? extends T> findAllPaged(Pageable pageable);
    Page<? extends T> findAllPagedSimplified(Pageable pageable);

    List<? extends T> findAllForSelectElement();

    boolean add(Dto dto);

}
