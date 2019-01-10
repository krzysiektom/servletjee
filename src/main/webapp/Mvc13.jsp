<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 06.01.19
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mvc13</title>
</head>
<body>
<form action="/Mvc13" method="post">
    Wprowadz dane książki
    <br>
    Tytuł:
    <input type="text" name="title">
    <br>
    Autor:
    <input type="text" name="author">
    <br>
    ISBN:
    <input type="text" name="isbn">
    <br>
    <input type="submit" value="Wyślij">

    <c:forEach begin="1" end="5" var="value" varStatus="status">
        Tytuł${value}:
        <input type="text" name="title${value}">
        <br>
        Autor${value}:
        <input type="text" name="author${value}">
        <br>
        ISBN${value}:
        <input type="text" name="isbn${value}">
        <br>
    </c:forEach>
</form>
</body>
</html>
