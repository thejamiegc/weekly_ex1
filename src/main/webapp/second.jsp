<%--
  Created by : tha
  Date: 02/02/2023
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Show users</title>
</head>
<body>
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
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.fname}"/></td>
            <td><c:out value="${user.lname}"/></td>
            <td><c:out value="${user.phone}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

