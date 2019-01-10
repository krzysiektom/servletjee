<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 06.01.19
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp12</title>
</head>
<body>
<c:forEach begin="${start}" end="${end}" var="value" varStatus="status">
    ${value}  first = ${status.first}<br>
</c:forEach>
</body>
</html>
