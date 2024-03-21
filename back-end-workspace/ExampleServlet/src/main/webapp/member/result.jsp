<%@page import="sku.lesson2.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
<h1>Output</h1>
<%
	MemberDTO dto = (MemberDTO)session.getAttribute("dto");
%>
<%=dto%>
</html>