package com.neo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
    
}