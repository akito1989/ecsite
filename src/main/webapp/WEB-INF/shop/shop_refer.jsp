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
<br/>
商品情報
<br/>
<br/>
<form:form modelAttribute="shopForm" action="add">
	商品コード<br/>
	<c:out value="${item.code}"/><br/>
	<form:input type="hidden" path="code" value="${item.code}" />
	商品名<br/>
	<c:out value="${item.name}"/><br/>
	<form:input type="hidden" path="name" value="${item.name}" />
	価格<br/>
	<c:out value="${item.price}円"/><br/>
	<form:input type="hidden" path="price" value="${item.price}" />
	<br/>
	<img src="http://localhost:8080/firstapp/shop/refer/${item.code}"/>
	<br/>
	<form:button>カートに入れる</form:button>
	<br/>
</form:form>
<br/>
<a href="<c:url value="/shop/"/>">戻る</a>
</body>
</html>