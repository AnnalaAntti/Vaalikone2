<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/header.css">
<title>Admin</title>

<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
  <header>
    <nav>
      <ul class="nav">
        <li><a href="index.html">KOTISIVU</a></li>
        <li><a href='/naytakysymykset'>VASTAA KYSYMYKSIIN</a></li>
        <li><a href='/naytaehdokas'>SELAA EHDOKKAITA</a></li>
        <li><a href="/AdminNakyma">KIRJAUDU</a></li> 
      </ul>
    </nav>
  </header>
<body>
	<a href='/yllapito'>Ehdokas Hallinta</a>
	<a href='/kysymysyllapito'>Kysymys hallinta</a>
	<br>
</body>
</html>