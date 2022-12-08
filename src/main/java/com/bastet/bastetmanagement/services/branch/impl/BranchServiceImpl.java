package com.bastet.bastetmanagement.services.branch.impl;

import com.bastet.bastetmanagement.daos.BranchDao;
import com.bastet.bastetmanagement.models.Branch;
import com.bastet.bastetmanagement.services.branch.BranchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Log4j2
@Service
public class BranchServiceImpl implements BranchService {

    @Resource
    private BranchDao branchDao;
    @Override
    public Branch findById(UUID id) {
        Branch branch = branchDao.findById(id).orElse(null);
        return branch;
    }
}
