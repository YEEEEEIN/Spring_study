<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Security</title>
</head>
<body>
	<h2>������ ��ť��Ƽ �±� ����</h2>
	<sec:authorize access="isAuthenticated()">
		<h5><sec:authentication property="principal.username"/>��, �ݰ��մϴ�.</h5>
		<form action="./logout" method="POST">
			<button type="submit">LOGOUT</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }" />				
		</form>
	</sec:authorize>
	
</body>
</html>