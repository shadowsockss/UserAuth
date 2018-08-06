package com.javen.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.UserDao;
import com.javen.model.User;
import com.javen.service.UserOperator;
@Service("userOperator") 
public class UserOperatorImpl implements UserOperator{
	/**
	 * 检验注册用户数据的合法性，并返回相应的状态码。
	 * @param user
	 * @return int userFeedBack
	 */
	@Resource  
    private UserDao userDao;
	
	@Override
	public int regist(User user){
		if(this.userDao.selectByUserName(user.getUserName()) != null) return USERNAME_EXIST;

		if(this.userDao.selectByEmail(user.getEmail()) != null) return EMAIL_EXIST;
		
		userDao.insertSelective(user);
		
		return SUCCESS;		
	}
	public User login(User user) {
		if(this.userDao.selectByUserNameAndPassword(user.getUserName(), user.getPassword()) != null) return user;
		
		return null;		
	}	
}