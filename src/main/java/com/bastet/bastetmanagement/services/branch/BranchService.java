package com.bastet.bastetmanagement.services.branch;

import com.bastet.bastetmanagement.models.Branch;
import com.bastet.bastetmanagement.services.GenericService;

import java.util.UUID;

public interface BranchService extends GenericService<Branch> {
    void add(Branch branch);
}
