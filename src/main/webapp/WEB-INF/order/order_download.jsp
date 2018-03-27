<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<spring:eval expression="@pullDownYear" var="pullDownYear"/>
<spring:eval expression="@pullDownMonth" var="pullDownMonth"/>
<spring:eval expression="@pullDownDay" var="pullDownDay"/>

<h2>ダウンロードしたい日付を選んで下さい</h2>
<form:form modelAttribute="daysForm" action="/firstapp/shop/orderDownload">
	<form:select path="year" items="${pullDownYear}"/>
	年
	<form:select path="month" items="${pullDownMonth}"/>
	月
	<form:select path="day" items="${pullDownDay}"/>
	日
	<br/>
	<form:button>ダウンロードへ</form:button>
</form:form>
</body>
</html>