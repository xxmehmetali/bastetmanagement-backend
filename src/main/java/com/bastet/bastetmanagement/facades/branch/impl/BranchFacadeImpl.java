package com.bastet.bastetmanagement.facades.branch.impl;

import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.facades.branch.BranchFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BranchFacadeImpl implements BranchFacade {
    @Override
    public BranchDto findById(UUID id) {
        return null;
    }
}
