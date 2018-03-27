<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
商品情報参照<br/>
<c:forEach var="product" items="${productList}"><br/>
	商品コード<br/>
	<c:out value="${product.code}"/><br/>
	商品名<br/>
	<c:out value="${product.name}"/><br/>
	価格<br/>
	<c:out value="${product.price}"/><br/>
	<br/>
	<img src="http://localhost:8080/firstapp/product/edit/${code}"/>
</c:forEach>
<a href="<c:url value="/product/list"/>">戻る</a>
</body>
</html>