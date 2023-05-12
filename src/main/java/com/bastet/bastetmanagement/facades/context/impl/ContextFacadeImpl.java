package com.bastet.bastetmanagement.facades.context.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ContextSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ContextSimplifiedDto;
import com.bastet.bastetmanagement.facades.context.ContextFacade;
import com.bastet.bastetmanagement.mappers.ContextMapper;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import com.bastet.bastetmanagement.models.Context;
import com.bastet.bastetmanagement.services.context.ContextService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class ContextFacadeImpl implements ContextFacade {
    @Resource
    private ContextService contextService;

    @Resource
    private ContextMapper contextMapper;

    @Override
    public ContextDto findById(UUID id) {
        return contextMapper.contextToContextDto(contextService.findById(id));
    }

    @Override
    public ContextSimplifiedDto findByIdSimplified(UUID id) {
        return contextMapper.contextToContextSimplifiedDto(contextService.findById(id));
    }

    @Override
    public Page<ContextDto> findAllPaged(Pageable pageable) {
        return contextService.findAllPaged(pageable).map(context -> contextMapper.contextToContextDto(context));
    }

    @Override
    public Page<ContextSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return contextService.findAllPaged(pageable).map(context -> contextMapper.contextToContextSimplifiedDto(context));
    }

    @Override
    public List<ContextSelectElementDto> findAllForSelectElement(){
        List<Context> contexts = contextService.findAll();
        return contextMapper.contextListToContextSelectElementDtoList(contexts);
    }

    @Override
    public boolean add(Dto dto) {
        Context context = contextMapper.contextDtoToContext((ContextDto) dto);
        return contextService.add(context);
    }
}
