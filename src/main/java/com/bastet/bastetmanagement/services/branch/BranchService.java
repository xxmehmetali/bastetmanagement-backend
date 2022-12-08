package com.bastet.bastetmanagement.services.branch;

import com.bastet.bastetmanagement.models.Branch;

import java.util.UUID;

public interface BranchService {
    Branch findById(UUID id);
}
