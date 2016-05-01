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
	<a href="helloworld">HelloWorld</a>
	
	<!-- Spring Test -->
	<form action="mvc/testMethod" method="post">
		<input type="submit" value="testMethod"/>
	</form>
	
	<!-- REST 风格的请求 -->
	<a href="mvc/testRest/1">Test Rest Get</a>
	<form action="mvc/testRest" method="post">
		<input type="submit" value="TestRest POST"/>
	</form>
	<form action="mvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="TestRest DELETE"/>
	</form>
	<form action="mvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="TestRest PUT"/>
	</form>
	
	<!-- 表单的绑定 -->
	<h5>表单数据的绑定：</h5>
	<form action="form/testPojo" method="post">
		UserName:<input type="text" name="userName"/>
		Password:<input type="password" name="password"/>
		Email:<input type="text" name="email"/><br>
		Age:<input type="text" name="age"/>
		City:<input type="text" name="address.city"/>
		Province:<input type="text" name="address.province"/>
		<input type="submit" name="Submit"/>
	</form>
	<h5>使用原生Servlet API作为目标方法的参数</h5>
	<a href="form/testServletAPI">Test ServletAPI</a>
	<h5>处理模型数据 1-ModelAndView</h5>
	<a href="form/testModelAndView"> Test ModelAndView</a>
	<h5>处理模型数据2-Map||Model||ModelMap</h5>
	<a href="form/testMap"> Test Map</a>
	
	<h5>将处理模型数据放到session里面去</h5>
	<a href="form/testSessionAttributes">Test SessionAttributes</a>
	<h5>实现类似struts2的pre拦截器的功能</h5>
	<form action="form/testModelAttribute" method="post">
		<input type="hidden" name="id" value="1"/>
		<input type="text" name="userName" value="xzl"/>
		<input type="text" name="email" value="123@123.com"/>
		<input type="text" name="age" value="12"/>
		<input type="submit" name="提交"/>
	</form>
	
	<h5>自定义视图解析器HelloView</h5>
	<a href="form/testView">Test View</a>
	

</body>
</html>