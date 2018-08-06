package com.javen.service;

import com.javen.model.User;

public interface UserOperator {
	/**
	 * 检验注册用户数据的合法性，并返回相应的状态码。
	 * @param user
	 * @return int userFeedBack
	 */
	public static final int USERNAME_EXIST=1;
	public static final int EMAIL_EXIST=2;
	public static final int SUCCESS =3;
	
	public int regist(User user);
	public User login(User user);
}
