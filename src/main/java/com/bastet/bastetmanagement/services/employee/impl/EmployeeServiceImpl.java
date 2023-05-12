package com.bastet.bastetmanagement.services.employee.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.EmployeeDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.services.employee.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    @Override
    public Employee findById(UUID id){
        return employeeDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Employee not found."));
    }

    @Override
    public Page<Employee> findAllPaged(Pageable pageable) {
        return employeeDao.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public boolean add(Employee employee) {
        return ResultUtil.extractSuccess(employeeDao.save(employee));
    }
}
