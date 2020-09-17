package com.grokonez.repository;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
