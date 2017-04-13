package com.imooc.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.imooc.dao.UserDao;
import com.imooc.domain.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void regist(User user) throws SQLException {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	String sql = "insert into user values(?,?,?,?,?,?,?)";
	Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),user.getNickname(),
			user.getEmail(),user.getState(),user.getCode()};
	queryRunner.update(sql,params);
	
	}


	@Override
	//���ݼ������ѯ�û��ķ���
	public User findByCode(String code) throws SQLException {
		
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where code = ? ";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class),code);
		return user;
		
	}


	@Override
	//Dao���޸��û��ķ���
	public void update(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update user set username=?,password=?,nickname=?,email=?,state=?,code=?where uid=? ";
		Object[] params = {user.getUsername(),user.getPassword(),user.getNickname(),
				user.getEmail(),user.getState(),user.getCode(),user.getUid()};
		queryRunner.update(sql,params);
	
	}

}
