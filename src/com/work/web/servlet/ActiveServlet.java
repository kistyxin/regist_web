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
//负责用户激活的servlet
public class ActiveServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
       //接收激活码
		String code = request.getParameter("code");
		//根据激活码查询用户
		UserService userService = new UserServiceImpl();
		User user = userService.findByCode(code);
		if(user!=null){
		//已经查询到，修改用户的状态
		user.setState(1);
		user.setCode(null);
		userService.update(user);
		request.setAttribute("msg", "您已经激活成功，请去登录");
		}else{
			//激活码没有查询到该用户
			request.setAttribute("msg", "激活码有误，请重新激活");
		}
		//页面跳转
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}catch(Exception e){
			throw new RuntimeException();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		

}
	}
