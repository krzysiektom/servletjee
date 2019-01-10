<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 06.01.19
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add-book</title>
</head>
<body>
<form action="/add-book" method="post">
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
    <a href="/all-books"><input type="button" value="Anuluj" ></a>
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
