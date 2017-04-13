package com.imooc.service.impl;

import java.sql.SQLException;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.utils.MailUtils;
public class UserServiceImpl implements UserService {

	
	//�û�ע��ҵ���
	public void regist(User user) throws Exception {
		// �����ݴ������ݿ⣬
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		//���ͼ����ʼ�
		MailUtils.sendMail(user.getEmail(),user.getCode());
		
		
	}
  //���ݼ������ѯ�û��ķ���
	public User findByCode(String code) throws Exception {
		UserDao userDao = new UserDaoImpl();
		
		return userDao.findByCode(code);
	}
	@Override
	//ҵ����޸��û��ķ���
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
UserDao userDao = new UserDaoImpl();
		
	userDao.update(user);
	}

}
