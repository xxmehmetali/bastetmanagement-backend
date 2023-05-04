package com.bastet.bastetmanagement.services.applicant;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.services.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ApplicantService extends GenericService<Applicant> {
}
