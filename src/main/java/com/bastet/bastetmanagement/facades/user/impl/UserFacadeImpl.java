package com.bastet.bastetmanagement.facades.user.impl;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.UserDto;
import com.bastet.bastetmanagement.facades.user.UserFacade;
import com.bastet.bastetmanagement.mappers.UserMapper;
import com.bastet.bastetmanagement.models.User;
import com.bastet.bastetmanagement.services.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class UserFacadeImpl implements UserFacade {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDto findById(UUID id) {
        User user = userService.findById(id);
        UserDto userDto = userMapper.userToUserDto(user);
        return userDto;
    }

    @Override
    public Dto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<? extends Dto> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public Page<? extends Dto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }

    @Override
    public List<? extends Dto> findAllForSelectElement() {
        return null;
    }

    @Override
    public boolean add(Dto dto) {
        return false;
    }
}
