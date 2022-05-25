<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome Page</h1>
	<h1>Welcome to Springmvc demo!</h1>
	<h1>Here is Menu jsp.</h1>
	<p>spring</p>
	<p>spring mvc</p>
	<p>spring boot</p>
	<p>spring cloud</p>
	
	<a href="showForm">跳转表单页-浏览器当前url下</a>
	<br/>
	<a href="/boot/showForm">跳转表单页-浏览器项目根url路径</a>
	<br/>
	<h5>a标签 href中的值为浏览器访问路径，而WEB-INF/views/webForm.jsp为服务器路径</h5>
	<a href="/WEB-INF/views/webForm.jsp">跳转表单页-服务器路径（这样写是错误的）</a>
	<br/><br/>
	<a href="/boot/testdb">TESTDB</a>
</body>
</html>