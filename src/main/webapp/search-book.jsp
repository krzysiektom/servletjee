<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 08.01.19
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search-book</title>
</head>
<body>
<h2>Podaj tytuł szukanej książki lub jego część </h2>
<form action="/search-book" method="post">
    Tytuł:
    <input type="text" name="searchTitle">
    <br>
    <a href="/all-books"><input type="button" value="Anuluj"></a>
    <input type="submit" value="Szukaj">
</form>
<c:if test="${{start}== true}">
    pierwszyr raz
</c:if>
<c:if test="${ {books} == null}">
<h3>Brak wyników</h3>
</c:if>
<c:if test="${not empty {books}}">
    <h2>Lista książek</h2>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Isbn</th>
            <th>Akcja</th>
        </tr>
        <c:forEach var="bookList" items="${books}">
            <tr>
                <th>${bookList.title}</th>
                <th>${bookList.author}</th>
                <th>${bookList.isbn}</th>
                <th><a href="/delete-book?id=${bookList.id}">Usuń</a>
                    <a href="/edit-book.jsp?id=${bookList.id}&title=${bookList.title}&author=${bookList.author}&isbn=${bookList.isbn}">Edytuj</a>
                </th>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
