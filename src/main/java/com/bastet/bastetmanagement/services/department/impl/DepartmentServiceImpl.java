package com.bastet.bastetmanagement.services.department.impl;

import com.bastet.bastetmanagement.daos.DepartmentDao;
import com.bastet.bastetmanagement.models.Department;
import com.bastet.bastetmanagement.services.department.DepartmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    @Override
    public Department findById(UUID id){
        Department department = departmentDao.findById(id).orElse(null);
        return department;
    }

    @Override
    public Page<Department> findAllPaged(Pageable pageable) {
        return null;
    }
}
