<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./home">Home</a> <a
					class="navbar-brand" href="./webtoons">도서 목록</a> 
					<a class="navbar-brand" href="./home">게시판</a>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">로그인</h1>
		</div>
	</div>
	
	<div class = "container col-md-4">
		<div class="float-right">
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
				<input type="submit" class="btn btn-sm btn-success" value="logout">
			</form:form>	
		</div>
	
	
		<div class="text-center">
			<h3 class="form-signin-heading">Please login</h3>
		</div>
		
		<c:if test="${not empty error}}"> <!-- 에러에 저장된 값이 있을 때 -->
			<div class="alert alert-danger">
				Username 또는 Password가 올바르지 않습니다.
			</div>
		</c:if>
		
		<form class="form-signin" action"<c:url value="/login/" />" method="post">
			<div class="form-group row">
				<input type="text" name="username" class="form-control"
					placeholder="User Name" required autofocus>
			</div>
			
			<div class="form-group row">
				<input type="text" name="password" class="form-control"
					placeholder="Password" required autofocus>
			</div>
			
			<div class="form-group row">
				<button class="btn btn-lg btn-success btn-block" type="submin">로그인</button>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>		
		</form>
	</div>

</body>
</html>