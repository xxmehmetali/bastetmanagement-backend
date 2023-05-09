package com.bastet.bastetmanagement.services.branch.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.BranchDao;
import com.bastet.bastetmanagement.models.Branch;
import com.bastet.bastetmanagement.services.branch.BranchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
public class BranchServiceImpl implements BranchService {

    @Resource
    private BranchDao branchDao;
    @Override
    public Branch findById(UUID id) {
        return branchDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Branch not found."));
    }

    @Override
    public Page<Branch> findAllPaged(Pageable pageable) {
        return branchDao.findAll(pageable);
    }

    @Override
    public void add(Branch branch) {
        branchDao.save(branch);
    }

    @Override
    public List<Branch> findAll() {
        return branchDao.findAll();
    }
}
