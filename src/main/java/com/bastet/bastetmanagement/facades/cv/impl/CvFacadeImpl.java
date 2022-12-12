package com.bastet.bastetmanagement.facades.cv.impl;

import com.bastet.bastetmanagement.core.configurations.mapstruct.CvMapper;
import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.DataResult;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.ErrorDataResult;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.SuccessDataResult;
import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CvSimplifiedDto;
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
    @Resource
    private CustomModelMapper customModelMapper;

    @Resource
    private CvMapper cvMapper;


    @Override
    public DataResult<List<Cv>> findAll(){
        try{
            return new SuccessDataResult<>(cvService.findAll(), "Data Listelendi.");
        }catch (Exception e){
            return new ErrorDataResult<>("Hata var.");
        }
    }

    @Override
    public CvDto findById(UUID id) {
        return cvMapper.cvToCvDto(cvService.findById(id));
    }

    @Override
    public CvSimplifiedDto findByIdSimplified(UUID id) {
        return customModelMapper.map(cvService.findById(id), CvSimplifiedDto.class);
    }
}
