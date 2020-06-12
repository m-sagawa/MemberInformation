<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.Dao" import="java.util.List" import="dao.Bean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>会員情報変更</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
	<h3>会員情報変更画面</h3><br>
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
		<button type="submit" name="from" value="update">表示</button>
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


	<form action="update-servlet" method="post">
	名前
	<%
	if(name == null){
		name = "　";
	}
	%>
	<input type="text" name="name" value=<%=name %>><br>
	年齢
	<%if(age == 0){%>
		<input type="text" value="　">
	<%}else{%>
		<input type="text" name="age" value=<%=age %>><br>
	<%} %><br>
	生年月日
	<select name="year">
		<%if(year == 0){%>
			<option></option>
		<%}else{%>
			<option><%=year %></option>
			<%for(int y=1920; y<=2020; y++){%>
				<option value="<%=y %>"><%=y %></option>
			<%} %>
		<%} %>
	</select>
	<select name="month">
		<%if(month == 0){%>
			<option></option>
		<%}else{%>
			<option><%=month %></option>
			<%for(int m=1; m<=12; m++){%>
				<option value="<%=m %>"><%=m %></option>
			<%} %>
		<%} %>
	</select>
	<select name="day">
		<%if(day == 0){%>
			<option></option>
		<%}else{%>
			<option><%=day %></option>
			<%for(int d=1; d<=31; d++){%>
				<option value="<%=d %>"><%=d %></option>
			<%} %>
		<%} %>
	</select><br>
	<a href="menu.jsp"><input type="button" value="戻る" class="button2"></a>
	<input type="submit" value="変更" class="button2">
	</form>
</body>
</html>