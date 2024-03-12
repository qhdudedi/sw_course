<%@page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
</head>
<body>
<h1>hello JSP</h1>
<%
    Random r = new Random();
    int number = r.nextInt(45)+1;
    System.out.println(number);
    out.print("<h1>"+number+"</h1>");
%>
<h1><%= number %></h1>
</body>
</html>