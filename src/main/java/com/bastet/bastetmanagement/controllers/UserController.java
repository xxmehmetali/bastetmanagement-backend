package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.customexceptions.UnauthorizedAccessException;
import com.bastet.bastetmanagement.core.security.services.impl.UserDetailsImpl;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.UserDto;
import com.bastet.bastetmanagement.facades.user.UserFacade;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BaseController<UserDto> {

    @Resource()
    private UserFacade userFacade;

    @GetMapping("/findCurrentUser")
    public Result findCurrentUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UUID userId = ((UserDetailsImpl) authentication.getPrincipal()).getId();
            UserDto userDto = (UserDto) userFacade.findById(userId);
            return wrapSuccessDataResultWithMessage(userDto, "User found successfuly");
        } catch (Exception e) {
            throw new UnauthorizedAccessException("Unauthorized access!");
        }

    }
}
