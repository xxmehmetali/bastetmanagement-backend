package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CvSelectElementDto;
import com.bastet.bastetmanagement.facades.cv.CvFacade;
import com.bastet.bastetmanagement.models.Cv;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cv")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CvController extends BaseController {
    @Resource
    private CvFacade cvFacade;

//    @GetMapping("/findAll")
//    @PreAuthorize("hasRole('USER')")
//    public DataResult<List<Cv>> findAll(){
//        return null;
//    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable(name = "id") UUID id) {
        return wrapSuccessDataResultWithMessage(cvFacade.findById(id), ResultConstants.foundMessage(Cv.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(cvFacade.findByIdSimplified(id), ResultConstants.foundMessage(Cv.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(cvFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(Cv.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(cvFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(Cv.class));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Result add(@RequestBody CvDto cvDto) {
        boolean success = cvFacade.add(cvDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Cv.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<CvSelectElementDto> cvSelectElementDtos = (List<CvSelectElementDto>) cvFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(cvSelectElementDtos, ResultConstants.dataListedMessageForSelection(Cv.class));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id") UUID id) {
        boolean success = cvFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(Cv.class));
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public Result update(@RequestBody CurrencyDto currencyDto) {
        boolean success = cvFacade.update(currencyDto);
        return wrapResultWithMessage(success, ResultConstants.updatedMessage(Cv.class));
    }

}
