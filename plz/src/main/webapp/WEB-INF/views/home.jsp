<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>

<form action="join" method="POST">
<table>
<tr><td>
아이디 : <input type="text" name="id">
</td></tr>
<tr><td>
비밀번호 : <input type="password" name="pw">
</td></tr>
<tr><td><input type="submit" value="회원가입"></td>
<td><button localhost="href='login'">로그인</button></td>
</tr>
</table>
</form>
</body>
</html>
