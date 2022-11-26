package com.bastet.bastetmanagement.services.cv;

import com.bastet.bastetmanagement.models.Cv;

import java.util.List;
import java.util.UUID;

public interface CvService {
    List<Cv> findAll();
    Cv findById(UUID id);
}
