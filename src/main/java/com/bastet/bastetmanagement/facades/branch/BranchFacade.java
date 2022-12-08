package com.bastet.bastetmanagement.facades.branch;

import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.models.Branch;

import java.util.UUID;

public interface BranchFacade {
    BranchDto findById(UUID id);
}
