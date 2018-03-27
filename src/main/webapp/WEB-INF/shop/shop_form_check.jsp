<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="custmerForm" method="POST" action="shopFormDone">
<div>
お名前<br/>
<c:out value="${custmerForm.name}"/>
<form:input type="hidden" path="name" value="${custmerForm.name}"/>
</div>
<div>
<br/>
メールアドレス<br/>
<c:out value="${custmerForm.email}"/>
<form:input type="hidden" path="email" value="${custmerForm.email}"/>
</div>
<br/>
<div>
郵便番号<br/>
<c:out value="${custmerForm.postal1}-${custmerForm.postal2}"/>
<form:input type="hidden" path="postal1" value="${custmerForm.postal1}"/>
<form:input type="hidden" path="postal2" value="${custmerForm.postal2}"/>
</div>
<div>
<br/>
住所<br/>
<c:out value="${custmerForm.address}"/>
<form:input type="hidden" path="address" value="${custmerForm.address}"/>
</div>
<div>
<br/>
電話番号<br/>
<c:out value="${custmerForm.tel}"/>
<form:input type="hidden" path="tel" value="${custmerForm.tel}"/>
</div>
<c:if test="${custmerForm.chumon == '2'}">
	<form:input type="hidden" path="chumon" value="${custmerForm.chumon}"/>
	<form:input type="hidden" path="password" value="${custmerForm.password}"/>
	<div>
	<br/>
	性別<br/>
	<c:out value="${custmerForm.danjyo}"/><br/>
	<form:input type="hidden" path="danjyo" value="${custmerForm.danjyo}"/>
	<br/>
	</div>
	<div>
	生まれ年<br/>
	<c:out value="${custmerForm.birth}年"/><br/>
	<form:input type="hidden" path="birth" value="${custmerForm.birth}"/>
	</div>
</c:if>
<br/>
<form:button>OK</form:button>
</form:form>
<br/>
<a href=<c:url value="/shop/shopForm"/>>戻る</a>
</body>
</html>