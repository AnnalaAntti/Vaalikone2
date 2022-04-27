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
<form action='../updatekysymys' method='post'>
<input type='text' name='id' value='${requestScope.kysymys.id }'>
<input type='text' name='kysymys' value='${requestScope.kysymys.kysymys }'>
<input type='text' name='numero' value='${requestScope.kysymys.numero }'>
<input type='submit' name='ok' value='OK'>
</form>
</body>
</html>