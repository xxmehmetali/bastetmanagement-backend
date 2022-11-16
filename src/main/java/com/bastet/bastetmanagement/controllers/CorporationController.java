package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.CorporationDao;
import com.bastet.bastetmanagement.models.Corporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/corporation")
public class CorporationController {

    @Autowired
    private CorporationDao corporationDao;

    @GetMapping("/getAll")
    public List<Corporation> getAll(){
        System.out.println("----------------------------\ncorporation:");
        System.out.println(corporationDao.findAll().get(0));

        System.out.println("corpartein projectleri");
        System.out.println(corporationDao.findAll().get(0).getProjects());
        return corporationDao.findAll();
    }
}
