<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 06.01.19
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<%--<c:out value="${book.title}, ${book.author}"/>--%>
<table>
    <c:forEach var="bookList" items="${books}">
        <tr>
            <td>${bookList.title}, ${bookList.author}</td><br>
        </tr>
    </c:forEach>
</table>


</body>
</html>
