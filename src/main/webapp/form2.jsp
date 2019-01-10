<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Mvc152</title>
</head>
<body>
<form action="/Mvc152" method="post">
    Wprowadz dane książki
    <br>
    <c:forEach begin="1" end="3" var="value" varStatus="status">
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
