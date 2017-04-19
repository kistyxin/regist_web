package com.imooc.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;
//�����û������servlet
public class ActiveServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
       //���ռ�����
		String code = request.getParameter("code");
		//���ݼ������ѯ�û�
		UserService userService = new UserServiceImpl();
		User user = userService.findByCode(code);
		if(user!=null){
		//�Ѿ���ѯ�����޸��û���״̬
		user.setState(1);
		user.setCode(null);
		userService.update(user);
		request.setAttribute("msg", "���Ѿ�����ɹ�����ȥ��¼");
		}else{
			//������û�в�ѯ�����û�
			request.setAttribute("msg", "���������������¼���");
		}
		//ҳ����ת
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}catch(Exception e){
			throw new RuntimeException();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		

}
	}
