package com.crud.service;

import com.crud.model.AppUser;

import java.util.List;

public interface AppUserService {



    void deleteById(Long id);

    AppUser findById(Long id);

    List<AppUser> getAppUsers();

    void save(AppUser user);

}
