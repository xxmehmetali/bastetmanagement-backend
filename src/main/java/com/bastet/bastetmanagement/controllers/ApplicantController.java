package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.dtos.ApplicantDto;
import com.bastet.bastetmanagement.models.Applicant;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @GetMapping("/getAll")
    public List<Applicant> getAll(){
        return null;
    }
}
