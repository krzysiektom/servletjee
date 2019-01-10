<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 08.01.19
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>all-books</title>
</head>
<body>
<h2>Lista książek</h2>
<table>
    <tr>
        <th>#</th>
        <th>Title</th>
        <th>Author</th>
        <th>Isbn</th>
        <th>Akcja</th>
    </tr>
    <c:forEach var="bookList" items="${books}" varStatus="theCount">
        <tr>
            <th>${theCount.count}</th>
            <th>${bookList.title}</th>
            <th>${bookList.author}</th>
            <th>${bookList.isbn}</th>
            <th><a href="/delete-book?id=${bookList.id}">Usuń</a>
                <a href="/edit-book.jsp?id=${bookList.id}&title=${bookList.title}&author=${bookList.author}&isbn=${bookList.isbn}">Edytuj</a>
            </th>
        </tr>
    </c:forEach>
</table>
<a href="/add-book"><input type="button" value="Dodaj książkę" ></a>
<h2>Podaj tytuł szukanej książki lub jego część </h2>
<form action="/search-book" method="post">
    Tytuł:
    <input type="text" name="searchTitle">
    <br>
    <a href="/all-books"><input type="button" value="Anuluj"></a>
    <input type="submit" value="Szukaj">
</form>
</body>
</html>
