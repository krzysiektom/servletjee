<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 06.01.19
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp11</title>
</head>
<body>
role = ${empty role ? "quest": role}
<br>
role=<c:out value="${role}" default="quest"/>
<br>
test = ${empty test ? "quest": test}

<br>
<c:choose>
    <c:when test="${not empty role}">
        role = ${role}
    </c:when>
    <c:otherwise>
        role =guest
    </c:otherwise>
</c:choose>
</body>
</html>
