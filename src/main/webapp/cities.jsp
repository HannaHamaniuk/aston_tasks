<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>City Page</title>

</head>
<body>
  <c:forEach var="city" items="${cities}">
           ${city.title}
      </c:forEach>
  <br>
  </body>
  </html>