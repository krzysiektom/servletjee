<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 08.01.19
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>edit-book</title>
</head>
<body>
<h2>Dane książki do edycji</h2>
<form action="/all-books" method="post">
    Id:
    <input type="text" name="id" value="${param.id}" readonly >
    <br>
    Tytuł:
    <input type="text" name="title" value="${param.title}" >
    <br>
    Autor:
    <input type="text" name="author" value="${param.author}">
    <br>
    ISBN:
    <input type="text" name="isbn" value="${param.isbn}">
    <br>

    <a href="/all-books"><input type="button" value="Anuluj"></a>
    <input type="submit" value="Zapisz">
</form>
</body>
</html>
