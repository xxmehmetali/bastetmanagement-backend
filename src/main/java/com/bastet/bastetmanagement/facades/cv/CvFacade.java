package com.bastet.bastetmanagement.facades.cv;

import com.bastet.bastetmanagement.core.utilities.results.DataResult;
import com.bastet.bastetmanagement.models.Cv;

import java.util.List;
import java.util.UUID;

public interface CvFacade {
    DataResult<List<Cv>> findAll();
    DataResult<Cv> findById(UUID id);
}
