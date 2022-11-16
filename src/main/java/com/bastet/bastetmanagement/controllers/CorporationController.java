package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.CorporationDao;
import com.bastet.bastetmanagement.models.Corporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporation")
public class CorporationController {

    @Autowired
    private CorporationDao corporationDao;

    @GetMapping("/getAll")
    public List<Corporation> getAll(){
        return corporationDao.findAll();
    }

    @PostMapping("/addCorporation")
    public String addCorporation(@RequestBody Corporation corporation){
        corporationDao.save(corporation);
        return "ok";
    }
}
