<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Security</title>
</head>
<body>
	<h2>스프링 시큐리티 태그 예시</h2>
	<sec:authorize access="hasRole('ROLE_MANAGER')" var="isAdmin">
	<p> <h3> 매니저 권한 화면입니다. </h3>
	</sec:authorize>
	
	<c:choose>
		<c:when test="${isAdmin}">
			<p> ROLE_ 중 입니다. </p>
			<p> <a href="<c:url value='/exam02/' />"> exam02로 이동하기 </a>
		</c:when>
		<c:otherwise>
			<p> 로그인 중이 아닙니다 </p>
			<p> <a href="<c:url value='/manger/tag' />"> /manger/tag로 이동하기 </a>	
		</c:otherwise>
	</c:choose>
</body>
</html>