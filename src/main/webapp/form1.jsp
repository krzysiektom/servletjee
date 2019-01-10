<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Mvc15</title>
</head>
<body>
<form action="/Mvc15" method="post">
    Wprowadz dane książki
    <br>
    Tytuł:
    <input type="text" name="title">
    Autor:
    <input type="text" name="author">
    ISBN:
    <input type="text" name="isbn">
    <br>
    <input type="submit" value="Wyślij">
</form>

</body>
</html>
