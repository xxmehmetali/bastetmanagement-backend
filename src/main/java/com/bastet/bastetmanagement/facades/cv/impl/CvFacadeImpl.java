package com.bastet.bastetmanagement.facades.cv.impl;

import com.bastet.bastetmanagement.core.utilities.results.DataResult;
import com.bastet.bastetmanagement.core.utilities.results.ErrorDataResult;
import com.bastet.bastetmanagement.core.utilities.results.SuccessDataResult;
import com.bastet.bastetmanagement.facades.cv.CvFacade;
import com.bastet.bastetmanagement.models.Cv;
import com.bastet.bastetmanagement.services.cv.CvService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class CvFacadeImpl implements CvFacade {
    @Resource
    CvService cvService;

    @Override
    public DataResult<List<Cv>> findAll(){
        try{
            return new SuccessDataResult<>(cvService.findAll(), "Data Listelendi.");
        }catch (Exception e){
            return new ErrorDataResult<>("Hata var.");
        }
    }

    @Override
    public DataResult<Cv> findById(UUID id) {
        try {
            return new SuccessDataResult<>(cvService.findById(id));
        }catch (Exception e){
            return new ErrorDataResult<>();
        }
    }
}
