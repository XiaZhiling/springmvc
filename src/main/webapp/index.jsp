<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test spring-mvc</title>
</head>
<body>

	<!-- Hello World -->
	<a href="/helloworld">HelloWorld</a>
	
	<!-- Spring Test -->
	<form action="/mvc/testMethod" method="post">
		<input type="submit" value="testMethod"/>
	</form>
	
	<!-- REST 风格的请求 -->
	<a href="/mvc/testRest/1">Test Rest Get</a>
	<form action="/mvc/testRest" method="post">
		<input type="submit" value="TestRest POST"/>
	</form>
	<form action="/mvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="TestRest DELETE"/>
	</form>
	<form action="/mvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="TestRest PUT"/>
	</form>
	
	

</body>
</html>