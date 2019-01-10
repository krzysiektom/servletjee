<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 06.01.19
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mvc14</title>
</head>
<body>
<form action="/Mvc14" method="post">
    Wprowadz dane książki
    <br>
    <c:forEach begin="1" end="5" var="value" varStatus="status">
        Tytuł${value}:
        <input type="text" name="title${value}">
        Autor${value}:
        <input type="text" name="author${value}">
        ISBN${value}:
        <input type="text" name="isbn${value}">
        <br>
    </c:forEach>
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
