<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 06.01.19
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp3.jsp</title>
</head>
<body>
param a = ${empty (a=param.a)? "brak": a} <br>
param b = ${empty (b=param.b)? "brak": b} <br>
</body>
</html>
