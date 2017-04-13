package com.imooc.service.impl;

import java.sql.SQLException;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.utils.MailUtils;
public class UserServiceImpl implements UserService {

	
	//用户注册业务层
	public void regist(User user) throws Exception {
		// 将数据存入数据库，
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		//发送激活邮件
		MailUtils.sendMail(user.getEmail(),user.getCode());
		
		
	}
  //根据激活码查询用户的方法
	public User findByCode(String code) throws Exception {
		UserDao userDao = new UserDaoImpl();
		
		return userDao.findByCode(code);
	}
	@Override
	//业务层修改用户的方法
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
UserDao userDao = new UserDaoImpl();
		
	userDao.update(user);
	}

}
