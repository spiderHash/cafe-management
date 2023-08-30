package com.manage.cafe.cafe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.cafe.cafe.POJO.User;

public interface UserDao extends JpaRepository<User,Integer> {

    public User findByEmail(String email);
    
}
