<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<spring:eval var="cartList" expression="@sessionCartForm.totleCartForm.cartList" />

<c:if test="${message != null}">
	<c:out value="${message}"/>
</c:if>
<c:if test="${message == null}">
<c:forEach var="cartForm" items="${cartList}">
	<c:out value="${cartForm.code}"/>
	<br/>
</c:forEach>
カートに追加しました。
</c:if>
 <div>
 <a href="<c:url value="/shop/"/>">トップページへ戻る</a>
 </div>
 </body>
</html>