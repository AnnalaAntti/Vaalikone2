<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Ehdokas"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
        <li><a href="Kirjaudu.html">KIRJAUDU</a></li> 
      </ul>
    </nav>
  </header>
<body>
	<h2>Tervetuloa Admin näkymään</h2>
	<br>
	<div class="Napit">
	<button>Ehdokas hallinta</button>
	<button>Kysymys hallinta</button>
	</div>
</body>
</html>