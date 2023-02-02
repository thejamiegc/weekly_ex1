<%--
  Created by : tha
  Date: 02/02/2023
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/frontController"/>
<h1>Users</h1>
<table>
    <thead>
    <tr>
        <th>User ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.users}" var="user">
    </tbody>
    <tr>
        <td>User ID: <c:out value="${user.id}"/></td>
        <td>First Name: <c:out value="${user.fname}"/></td>
        <td>Last Name: <c:out value="${user.lname}"/></td>
        <td>Phone: <c:out value="${user.phone}"/></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>

