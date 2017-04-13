package com.imooc.dao;

import java.sql.SQLException;

import com.imooc.domain.User;

public interface UserDao {
public void regist(User user) throws SQLException;

public User findByCode(String code)throws SQLException;

public void update(User user)throws SQLException;
}
