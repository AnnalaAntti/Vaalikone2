<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='../addkysymys' method='post'>
<input type='text' name='kysymys' value=''>
<input type='text' name='numero' value=''>
<input type='submit' name='ok' value='OK'>
</form>
<ol>
<c:forEach var="kysymys" items="${requestScope.kysymykset}">
	<li>${kysymys} <a href='/rest/kysymyksetservice/deletekysymys/${kysymys.id}'>Delete</a> <a href='../readtoupdatekysymys?id=${kysymys.id}'>Update</a>
</c:forEach>
</ol>
</body>
</html>
