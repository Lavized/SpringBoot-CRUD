package com.crud.repository;

import com.crud.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository  extends CrudRepository<AppUser,Long> {


}
