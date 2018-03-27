<%@page import="example.app.form.CartForm"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<spring:eval var="cartList" expression="@sessionCartForm.totleCartForm.cartList" />
<h2>カートの中身</h2>
<br/>

<!--el式をスクリプトレットに変換してます（本来望ましくないです…）  -->
<%
List<CartForm> list = (List<CartForm>)pageContext.findAttribute("cartList");
int itemNumber = list.size();
if(itemNumber == 0){%>
	<p>カートに商品が入っていません</p><br/>
<%}else{
%>
<form:form modelAttribute="cartForm" method="post">
<table border="1">
	<tr>
		<td>商品</td>
		<td>商品画像</td>
		<td>価格</td>
		<td>数量</td>
		<td>小計</td>
		<td>削除</td>
	</tr>
	<c:forEach var="item"  items="${cartList}">
		<tr>
			<td><c:out value="${item.name}"/></td>
			<td><img src="http://localhost:8080/firstapp/shop/refer/${item.code}"/></td>
			<td><c:out value="${item.price}円"/></td>
			<td>
				<form:input path="numbersList" value="${item.number}"/>
			</td>
			<td><c:out value="${item.price * item.number}円"/></td>
			<td><form:checkbox name="check" path="check" value="OK"/></td>
		</tr>
	</c:forEach>
</table>
<br/>
<form:button name="number">数量変更</form:button>
<form:button name="delete">カートの中身を空にする</form:button>
</form:form>
<c:if test="${errorMessages != null}">
	<br/>
	<c:out value="${errorMessages.number}"/>
	<c:out value="${errorMessages.numberRange}"/>
</c:if>
<%} %>
<br/>
<a href="<c:url value="/shop/"/>">戻る</a>
<c:if test="${cartList.size() != 0}">
	<br/>
	<a href="<c:url value="/shop/shopForm"/>" >ご購入手続きへ進む</a>
</c:if>
</body>
</html>