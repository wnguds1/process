<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">

</style>
</head>
<body>
<table>
<c:forEach items="${boardList}" var="blist">
<tr>
<td>번호</td>
<td>제목</td>
<td>내용</td>
<td>작성일</td>
<td>조회수</td>
</tr>

<tr>
<td>${blist.bid}</td>
<td>${blist.subject}</td>
<td>${blist.content}</td>
<td>${blist.bdate}</td>
<td>${blist.bhit}</td>
</tr>
</c:forEach>
</table>
<button type="button"onclick="location.href='boardWriteform'">글쓰기</button>
</body>
</html>