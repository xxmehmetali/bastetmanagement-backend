package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.EmployeeDao;
import com.bastet.bastetmanagement.daos.SocialActivityDao;
import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivitySelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivitySimplifiedDto;
import com.bastet.bastetmanagement.facades.socialactivity.SocialActivityFacade;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.models.SocialActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/socialActivity")
public class SocialActivityController extends BaseController {
    @Resource
    private SocialActivityFacade socialActivityFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(socialActivityFacade.findById(id), "");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(socialActivityFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(socialActivityFacade.findAllPaged(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(socialActivityFacade.findAllPagedSimplified(pageable), "");
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody SocialActivityDto socialActivityDto){
        boolean success = socialActivityFacade.add(socialActivityDto);
        return wrapResultWithMessage(success, "selamke");
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<SocialActivitySelectElementDto> socialActivitySelectElementDtos = (List<SocialActivitySelectElementDto>) socialActivityFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(socialActivitySelectElementDtos, "");
    }
//    @PutMapping("/save/{employeeId}/{socialActivityId}")
//    public SocialActivity save(@PathVariable("employeeId") UUID employeeId,
//                               @PathVariable("socialActivityId") UUID socialActivityId){
//        Employee employee = employeeDao.findById(employeeId).get();
//        SocialActivity socialActivity = socialActivityDao.findById(socialActivityId).get();
//        try {
//            List<Employee> socialActivity_employees = socialActivity.getEmployees();
//            socialActivity_employees.add(employee);
//            socialActivity.setEmployees(socialActivity_employees);
//            socialActivityDao.save(socialActivity);
//            return socialActivity;
//        }catch (Exception e){
//            return null;
//        }
//    }
}
