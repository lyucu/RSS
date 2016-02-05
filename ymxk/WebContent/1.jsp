<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tt.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <a href="load" >load</a> -->
<ul>
<%
	out.println("123");
	Map<String, String> map = new RssReader().run();
	for (String s : map.keySet()) {
		out.println("<li><a href='read?" + s + "'>" + map.get(s)+ "</a></li>");
	}

%>
</ul>
</body>
</html>