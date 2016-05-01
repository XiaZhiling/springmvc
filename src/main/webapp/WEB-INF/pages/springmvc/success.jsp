<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Success!!!<br>
	<h5>将处理的模型数据放到request里头</h5>
	time:${requestScope.time }<br>
	<h5>使用Map/model/MapAndModel处理的模型数据放到request里头</h5>
	names:${requestScope.names }<br>
	
	<h5>将处理的模型数据放到session里头</h5>
	request user:${requestScope.user }<br>
	session user:${sessionScope.user }<br>
	request school:${requestScope.school }<br>
	session school:${sessionScope.school }<br>
	
	<!-- 国际化资源文件 -->
	<fmt:message key="i18n.userName"></fmt:message>
	<fmt:message key="i18n.password"></fmt:message>
</body>
</html>