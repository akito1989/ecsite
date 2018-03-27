<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
ようこそゲスト様
<a href=<c:url value=""/>>会員ログイン</a>
<br/>
<br/>
商品一覧
<br/>
<form:form modelAttribute="shopForm" action="refer">
<c:forEach var="item" items="${itemList}">
	<form:radiobutton path="code" value="${item.code}"/>
	<c:out value="${item.name}"/>
	<br/>
</c:forEach>
<form:button name="refer">商品詳細を見る</form:button>
<form:button name="cartLook">カートを見る</form:button>
</form:form>
</body>
</html>