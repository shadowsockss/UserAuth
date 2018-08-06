package com.javen.service.impl;
import javax.annotation.Resource;  
  



import org.springframework.stereotype.Service;  

import com.javen.dao.UserDao;
import com.javen.model.User;
import com.javen.service.UserService;
  
  
@Service("userService")  
public class UserServiceImpl implements UserService {  
    @Resource  
    private UserDao userDao;  
    
    public User getUserById(int userId) {  
        
        return this.userDao.selectByPrimaryKey(userId);  
    }

	@Override
	public User getUserByUserName(String userName) {
		
		return this.userDao.selectByUserName(userName);
	}  
  
}  
