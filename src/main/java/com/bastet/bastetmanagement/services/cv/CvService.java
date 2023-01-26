package com.bastet.bastetmanagement.services.cv;

import com.bastet.bastetmanagement.models.Cv;
import com.bastet.bastetmanagement.services.GenericService;

import java.util.List;
import java.util.UUID;

public interface CvService extends GenericService<Cv> {
    List<Cv> findAll();
}
