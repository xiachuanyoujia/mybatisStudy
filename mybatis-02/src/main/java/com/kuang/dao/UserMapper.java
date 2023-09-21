package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper{
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deletUser(int id);
}

