<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
  
  <body>
  <h1>用户注册的页面</h1>
  <!--提交到servlet  -->
  <from action = "${pageContext.request.contextPath }/RegistServlet" method = "post">
  <table width="600" border ="1">
  <tr>
  <td>用户名</td>
  <td><input type = "text" name = "username"></td>
  </tr>
  <tr>
  <td>密码</td>
  <td><input type = "text" name = "password"></td>
  </tr>
  <tr>
  <td>昵称</td>
  <td><input type = "text" name = "nickname"></td>
  </tr>
  <tr>
  <td>邮箱</td>
  <td><input type = "text" name = "email"></td>
  </tr>
  <tr>
  <td colspan ="2"><input type="submit" value="注册"></td>

  </tr>
  </table>
  </from>
  
  </body>
</html>
