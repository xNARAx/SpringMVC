<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Sample Page</title>
</head>
<body>
	<h1>Login Sample Page<h1/>
	<form name="frmLogin" method="post" action="${pageContext.request.contextPath}/gate/login/actionLogin.do">
		<input type="text" id="user_id" name="user_id">
		<input type="password" id="user_pw" name="user_pw">
		<button>로그인</button>
	</form>
</body>
</html>