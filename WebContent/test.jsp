<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.Bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報</title>
</head>
<body>
	<% Bean bean = (Bean)request.getAttribute("bean"); %>
	<%
	String name = bean.getName();
	int age = bean.getAge();
	int year = bean.getYear();
	int month = bean.getMonth();
	int day = bean.getDay();
	%>
	名前：<%=name %><br>
	年：<%=age %><br>
	生年月日：<%=year %><%=month %><%=day %>
</body>
</html>