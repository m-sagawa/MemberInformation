<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.Bean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
	<h3>メニュー画面</h3><br>
	<a href="Registration.jsp">
		<input type="button" value="会員情報新規登録" class="button1">
	</a><br>
	<a href="Update.jsp">
		<input type="button" value="　会員情報変更　" class="button1">
	</a><br>
	<a href="Delete.jsp">
		<input type="button" value="　会員情報削除　" class="button1">
	</a><br>
</body>
</html>