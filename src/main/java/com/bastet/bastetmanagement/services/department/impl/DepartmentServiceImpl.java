package com.bastet.bastetmanagement.services.department.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.DepartmentDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Department;
import com.bastet.bastetmanagement.services.department.DepartmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    @Override
    public Department findById(UUID id) {
        return departmentDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Department not found."));
    }

    @Override
    public Page<Department> findAllPaged(Pageable pageable) {
        return departmentDao.findAll(pageable);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public boolean add(Department department) {
        return ResultUtil.extractSuccess(departmentDao.save(department));
    }
    @Override
    public boolean deleteById(UUID id) {
        departmentDao.deleteById(id);
        return ! departmentDao.existsById(id);
    }
}
