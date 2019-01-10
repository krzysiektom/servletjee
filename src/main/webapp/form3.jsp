<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 06.01.19
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mvc154</title>
</head>
<body>
<table>
    <c:forEach var="bookList" items="${books}">
        <tr>
            <td>${bookList.toString()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
