<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加书籍</title>
</head>
<body>
   <form method="post">
      书名：<input type="text" name="title"/><br/>
      作者：<input type="text" name="author"/><br/>
      简介：<textarea rows="5"cols="80"name="brief"></textarea><br/>
      <input type="submit"/>
   </form>
</body>
</html>