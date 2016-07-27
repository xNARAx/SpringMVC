<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>Menu List Sample Page</title>
</head>
<body>
	<h1>Menu List Sample Page</h1>
	${serverTime}
	
	${list.get(0).user_id}
	<c:forEach var="item" items="${list}" >
		${item.user_id} <br/>
	</c:forEach>
</body>
</html>