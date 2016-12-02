<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
 <h1>  Welcome~ BLUE</h1>
    <a href="book/add">添加</a>
    <table>
      <thead>
         <tr><th>书名</th><th>简介</th><th>作者</th><th>操作</th></tr>
      </thead>
      <tbody>
         <core:forEach var="book" items="${books}">
             <tr>
               <td><a href="book/${book.id}">${book.title}</a></td>
               <td><font color="grey">${book.brief}</font></td>
               <td><font color="#333333">${book.author}</font></td>
               <td>
                  <a href="book/delete?id=${book.id}">删除</a>
                  <a href="book/edit?id=${book.id}">修改</a>
               </td>
             </tr>
         </core:forEach>
      </tbody>
    </table>
</body>
</html>