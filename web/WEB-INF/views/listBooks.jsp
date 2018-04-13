<%--
  Created by IntelliJ IDEA.
  User: wagenhuberg
  Date: 23.03.2018
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h1>Bücherliste</h1>
<p>Ihre Bücher sind:</p>
<table>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.isbn}</td>
            <td>${book.titel}</td>
            <td>${book.author}</td>
            <td><a href="deleteBooks.do?id=${book.id}">Löschen</a></td>
        </tr>
    </c:forEach>
</table>




</body>
<head>
    <title>Bücherliste</title>
</head>
</html>
