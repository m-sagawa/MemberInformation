<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.Dao" import="java.util.List" import="dao.Bean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>会員情報削除</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
	<h3>会員情報削除画面</h3><br>
	<% String message = (String)request.getAttribute("message"); %>
	<%
	if(message == null){
		message = " ";
	}
	%>
	<%=message %>

	<form action="display-servlet" method="post">
		会員番号
		<input type="text" name="member">
		<button type="submit" name="from" value="delete">表示</button>
	</form>

	<%
	Bean memberBean = null;
	String name = null;
	int age = 0;
	int year = 0;
	int month = 0;
	int day = 0;
	memberBean = (Bean)request.getAttribute("memberBean");

	if(memberBean == null){

	}else{
		name = memberBean.getName();
		age = memberBean.getAge();
		year = memberBean.getYear();
		month = memberBean.getMonth();
		day = memberBean.getDay();
	}
	%>

	名前
	<%
	if(name == null){
		name = "　";
	}
	%>
	<input type="text" name="name" value=<%=name %> disabled><br>
	年齢
	<%if(age == 0){%>
		<input type="text" value="　" disabled>
	<%}else{%>
		<input type="text" name="age" value=<%=age %> disabled><br>
	<%} %><br>
	生年月日
	<select name="year" disabled>
		<%if(year == 0){%>
			<option></option>
		<%}else{%>
			<option><%=year %></option>
			<% %>
		<%} %>
	</select>
	<select name="month" disabled>
		<%if(month == 0){%>
			<option></option>
		<%}else{%>
			<option><%=month %></option>
		<%} %>
	</select>
	<select name="day" disabled>
		<%if(day == 0){%>
			<option></option>
		<%}else{%>
			<option><%=day %></option>
		<%} %>
	</select><br>
	<form action="delete-servlet" method="post">
	<a href="menu.jsp"><input type="button" value="戻る" class="button2"></a>
	<input type="submit" value="削除" class="button2">
	</form>
</body>
</html>