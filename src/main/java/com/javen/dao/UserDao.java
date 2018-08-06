package com.javen.dao;

import com.javen.model.User;


public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByUserName(String userName);
    
    User selectByEmail(String email);
    
    User selectByUserNameAndPassword(String userName, String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
}