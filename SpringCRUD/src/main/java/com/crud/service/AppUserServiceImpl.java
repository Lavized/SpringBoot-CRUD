package com.crud.service;

import com.crud.model.AppUser;
import com.crud.repository.AppUserRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;

    public AppUserServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void deleteById(Long id) {
         userRepository.deleteById(id);
    }

    @Override
    public AppUser findById(Long id) {
        Optional<AppUser> appUser = userRepository.findById(id);
        if (!appUser.isPresent()) {
            throw new RuntimeException("User Not found");
        }
        return appUser.get();
    }

    @Override
    public List<AppUser> getAppUsers() {
        List<AppUser> users = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public void save(AppUser user) {
        userRepository.save(user);
    }
}
