<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Main Page</title>

</head>
<body>
<table border="1">
    <tr>

        <th>Name</th>
        <th>Capital</th>
        <th>President</th>
        <th>Population</th>
        <th>Action</th>
    </tr>
    <c:forEach var="country" items="${countries}">
        <tr>
            <td>${country.name}</td>
            <td>${country.capital}</td>
            <td>${country.president}</td>
            <td>${country.population}</td>
            <td>
                <a href="/view?id=${country.id}">view cities</a>
            </td>
        </tr>
    </c:forEach>
    </table>
<br>

<a href ="/add">add new country</a>


</body>
</html>