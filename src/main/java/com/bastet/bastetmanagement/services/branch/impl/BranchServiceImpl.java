package com.bastet.bastetmanagement.services.branch.impl;

import com.bastet.bastetmanagement.daos.BranchDao;
import com.bastet.bastetmanagement.models.Branch;
import com.bastet.bastetmanagement.services.branch.BranchService;

import javax.annotation.Resource;
import java.util.UUID;

public class BranchServiceImpl implements BranchService {

    @Resource
    private BranchDao branchDao;

    public Branch findById(UUID id) {
        return new Branch();

    }
}
