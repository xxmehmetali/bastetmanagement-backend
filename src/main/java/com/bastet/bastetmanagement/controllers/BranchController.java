package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.selectdtos.BranchSelectElementDto;
import com.bastet.bastetmanagement.facades.branch.BranchFacade;
import com.bastet.bastetmanagement.models.Branch;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/branch")
public class BranchController extends BaseController {
    @Resource
    private BranchFacade branchFacade;


    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(branchFacade.findById(id), ResultConstants.foundMessage(Branch.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(branchFacade.findByIdSimplified(id), ResultConstants.foundMessage(Branch.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(branchFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(Branch.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(branchFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(Branch.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<BranchSelectElementDto> branchSelectElementDtos = (List<BranchSelectElementDto>) branchFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(branchSelectElementDtos, ResultConstants.dataListedMessageForSelection(Branch.class));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Result add(@RequestBody BranchDto branchDto) {
        boolean success = branchFacade.add(branchDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Branch.class));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id") UUID id) {
        //corp = 3e751b9d-2213-4eff-9426-43b20fab3a5e
        // branch name xaoxao
        // emp 8304e5ff-6324-4863-ac51-8fcbc6812b13
        boolean success = branchFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(Branch.class));
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public Result update(@RequestBody BranchDto branchDto) {
        boolean success = branchFacade.update(branchDto);
        return wrapResultWithMessage(success, ResultConstants.updatedMessage(Branch.class));
    }

}
