<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
商品一覧<br/>
<form:form modelAttribute="productForm" action="/firstapp/product/edit">
<c:forEach var="product" items="${productList}">
	<form:radiobutton path="code" value="${product.code}"/>
	<c:out value="${product.name}"/>
	<br/>
</c:forEach>
<form:button name="refer">参照する</form:button>
<form:button name="add">追加する</form:button>
<form:button name="update">修正する</form:button>
<form:button name="delete">削除する</form:button>
</form:form>
</br>
<a href="<c:url value="/staff"/>">トップ画面へ</a>
</body>
</html>