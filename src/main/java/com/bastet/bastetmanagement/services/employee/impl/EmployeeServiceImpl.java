package com.bastet.bastetmanagement.services.employee.impl;

import com.bastet.bastetmanagement.daos.EmployeeDao;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.services.employee.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Override
    public Employee findById(UUID id){
        Employee employee = employeeDao.findById(id).orElse(null);
        return employee;
    }
}
