<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<spring:eval expression="@pullBirth" var="birth"/>
<p>お客様情報を入力して下さい</p>
<form:form modelAttribute="customerForm" method="post">
	<div>
		お名前
		<br/>
		<form:input type="text" path="name"/>
        <form:errors path="name" />
	</div>
	<div>
		メールアドレス
		<br/>
		<form:input type="text" path="email"/>
        <form:errors path="email" />
	</div>
	<div>
		郵便番号
		<br/>
		<form:input type="text" path="postal1"/>
		<form:input type="text" path="postal2"/>
        <form:errors path="postal1" />
        <form:errors path="postal2" />
	</div>
	<div>
		住所
		<br/>
		<form:input type="text" path="address"/>
        <form:errors path="address" />
	</div>
	<div>
		電話番号
		<br/>
		<form:input type="text" path="tel"/>
        <form:errors path="tel" />
	</div>
	<div>
		<br/>
		<form:radiobutton path="chumon" label="今回だけの注文" value="1"/>
		<form:radiobutton path="chumon" label="会員登録しての注文" value="2"/>
	</div>
	<div>
		<br/>
		----会員登録する方は以下の項目も入力して下さい。----<br/>
	</div>
	<div>
		<br/>
		パスワードを入力して下さい。<br/>
		<form:input type="password" path="password"/>
	</div>
	<div>
		<br/>
		パスワードをもう一度入力して下さい。<br/>
		<form:input type="password" path="password2"/>
	</div>
	<div>
		<br/>
		性別<br/>
		<form:radiobutton  path="danjyo" label="男性" value="男性"/>
		<form:radiobutton  path="danjyo" label="女性" value="女性"/>
	</div>
	<div>
		<br/>
		生まれた年<br/>
		<form:select  path="birth" items="${birth}"/>
	</div>
	<div>
		<br/>
		<form:button>OK</form:button>
	</div>
</form:form>
<br/>
<c:if test="${errorMessages != null }">
	<c:out value="${errorMessages.name}"></c:out><br/>
	<c:out value="${errorMessages.mail}"></c:out><br/>
	<c:out value="${errorMessages.postal1}"></c:out><br/>
	<c:out value="${errorMessages.postal2}"></c:out><br/>
	<c:out value="${errorMessages.address}"></c:out><br/>
	<c:out value="${errorMessages.tel}"></c:out><br/>
	<c:out value="${errorMessages.password}"></c:out><br/>
</c:if>
<a name="cartLook" href="<c:url value="/shop/refer"/>">戻る</a>
</body>
</html>