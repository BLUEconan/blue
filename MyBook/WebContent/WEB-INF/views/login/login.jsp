<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
</head>
<body>
   <h1>${error}</h1>
   <form method="post">
      <input type="text" name="userName" placeholder="请输入用户名"/><br/>
      <input type="passWord" name="passWord"placeholder="请输入用密码"/><br/>
      <input type="submit"/>
   </form>
</body>
</html>