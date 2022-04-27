<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"  %>
<%@ page import="data.Kysymys"  %>
<%@ page import="javax.ws.rs.client.*"  %>
<%@ page import="javax.ws.rs.client.Invocation.Builder"  %>
<%@ page import="javax.ws.rs.core.*"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>From request</h3>
<ol>
<c:forEach var="kysymys" items="${requestScope.kysymykset }">
	<li>${kysymys}
</c:forEach>
</ol>

<h3>From method</h3>

<ol>
<c:forEach var="kysymys" items="<%=readAll() %>">
	<li>${kysymys}
</c:forEach>
</ol>
</body>
</html>

<%!
List<Kysymys> readAll() {
	String uri = "http://127.0.0.1:8080/rest/kysymyksetservice/readkysymys";
	Client c=ClientBuilder.newClient();
	WebTarget wt=c.target(uri);
	Builder b=wt.request();
	GenericType<List<Kysymys>> genericList = new GenericType<List<Kysymys>>() {};
	
	List<Kysymys> list=b.get(genericList);
	return list;
/* 	String bookjsonlist=b.get(String.class);
	//Print the contents of the list
	System.out.println("All the books");
	for (Book x:list){
		System.out.println(x);
	}
	System.out.println(bookjsonlist);
 */
 }
%>