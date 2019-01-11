<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<% session.removeAttribute("username"); 
	session.invalidate(); 
	out.print("<script>window.location.href='/wms/login'</script>"); %>
</body>
</html>
