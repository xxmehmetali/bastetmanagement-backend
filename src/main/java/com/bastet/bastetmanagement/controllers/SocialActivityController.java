package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.EmployeeDao;
import com.bastet.bastetmanagement.daos.SocialActivityDao;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.models.SocialActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/socialActivity")
public class SocialActivityController {

    @Autowired
    private SocialActivityDao socialActivityDao;

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getAll")
    public List<SocialActivity> getAll(){
        return socialActivityDao.findAll();
    }

    @PutMapping("/save/{employeeId}/{socialActivityId}")
    public SocialActivity save(@PathVariable("employeeId") UUID employeeId,
                               @PathVariable("socialActivityId") UUID socialActivityId){
        Employee employee = employeeDao.findById(employeeId).get();
        SocialActivity socialActivity = socialActivityDao.findById(socialActivityId).get();
        try {
            List<Employee> socialActivity_employees = socialActivity.getEmployees();
            socialActivity_employees.add(employee);
            socialActivity.setEmployees(socialActivity_employees);
            socialActivityDao.save(socialActivity);
            return socialActivity;
        }catch (Exception e){
            return null;
        }
    }
}
