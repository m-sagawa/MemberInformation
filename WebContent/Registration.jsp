<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.Dao" import="java.util.List" import="dao.Bean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>会員情報新規登録</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
	<h3>会員情報新規登録画面</h3><br>
	<% String message = (String)request.getAttribute("message"); %>
	<%
	if(message == null){
		message = " ";
	}
	%>
	<%=message %>
	<form action="registration-servlet" method="post">
		　　名前　　
		<input type="text" name="name"><br>
		　　年齢　　
		<input type="text" name="age"><br>
		生年月日　
		<select name="year">
			<option value=""></option>
			<%for(int y=1920; y<=2020; y++){%>
				<option value="<%=y %>"><%=y %></option>
			<%} %>
		</select>
		<select name="month">
			<option value=""></option>
			<%for(int m=1; m<=12; m++){%>
				<option value="<%=m %>"><%=m %></option>
			<%} %>
		</select>
		<select name="day">
			<option value=""></option>
			<%for(int d=1; d<=31; d++){%>
				<option value="<%=d %>"><%=d %></option>
			<%} %>
		</select><br>

		<a href="menu.jsp"><input type="button" value="戻る" class="button2"></a>
		<input type="submit" value="登録" class="button2">
	</form>

<%--
	<%
		Dao dao = new Dao();
		List<Bean> memberList = dao.memberList();
	%>
	<table>
		<caption>メンバーリスト</caption>
		<tr><th>会員番号</th><th>名前</th><th>年齢</th><th>年</th><th>月</th><th>日</th></tr>
		<%for(Bean m : memberList){
			%>
			<tr>
			<%String member = m.getMember(); %>
			<td><%=member %></td>
			<%String name = m.getName(); %>
			<td><%=name %></td>
			<%int age = m.getAge(); %>
			<td><%=age %></td>
			<%int year = m.getYear(); %>
			<td><%=year %></td>
			<%int month = m.getMonth(); %>
			<td><%=month %></td>
			<%int day = m.getDay(); %>
			<td><%=day %></td>
			</tr>
		<%} %>
	</table>
--%>
</body>
</html>