package com.bastet.bastetmanagement.services.user.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.UserDao;
import com.bastet.bastetmanagement.models.User;
import com.bastet.bastetmanagement.services.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findById(UUID id) {
        User user = userDao.findById(id).orElseThrow(() -> new ModelNotFoundException("User not found"));;
        return user;
    }

    @Override
    public Page<User> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean add(User model) {
        return false;
    }

    @Override
    public boolean deleteById(UUID id) {
        return false;
    }
}
