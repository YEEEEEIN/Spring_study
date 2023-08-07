<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Security</title>
</head>
<body>
	<h3>스프링 시큐리티</h3>
	<ul>
		<li>웹 요청 URL : <a href="<c:url value='/home/main' />"> /home/main </a></li>
		<li>웹 요청 URL : <a href="<c:url value='/member/main' />"> /member/main </a></li>
		<li>웹 요청 URL : <a href="<c:url value='/manager/main' />"> /manager/main </a></li>
		<li>웹 요청 URL : <a href="<c:url value='/admin/main' />"> /admin/main </a></li>
	</ul>
</body>
</html>