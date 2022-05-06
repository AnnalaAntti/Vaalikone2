<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Kysymys"  %>
<%@ page import="javax.ws.rs.client.*"  %>
<%@ page import="javax.ws.rs.client.Invocation.Builder"  %>
<%@ page import="javax.ws.rs.core.*"  %>
<%@ page import="java.util.List"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/ylläpito.css">
<title>Ylläpito</title>

<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body>
  <header>
    <nav>
      <ul class="nav">
        <li><a href="index.html">KOTISIVU</a></li>
        <li><a href='/naytakysymykset'>VASTAA KYSYMYKSIIN</a></li>
        <li><a href='/naytaehdokas'>SELAA EHDOKKAITA</a></li>
        <li><a href="Kirjaudu.html">KIRJAUDU</a></li> 
      </ul>
    </nav>
  </header>
  <div class="container">
	<h3>Ylläpidä kysymyksiä</h3>
	<ol>
		<c:forEach var="kysymys" items="${requestScope.kysymykset}">
	<li>${kysymys} <a href='/rest/kysymyksetservice/deletekysymys/${kysymys.id}'>Delete</a> <a href='../readtoupdatekysymys?id=${kysymys.id}'>Update</a>
</c:forEach>
	</ol>
	<div class="lista">
	</div>
	<br>
	<a>Uusi kysymys</a>
<form action='../addkysymys' method='post'>
<input type='text' name='kysymys' value=''>
<input type='text' name='numero' value=''>
<input type='submit' name='ok' value='OK'>
</form>
	<br>
</div>
</body>
</html>