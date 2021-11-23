<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HAL person</title>
</head>
<body>
<%@page import="ee.hal.dao.PersonDao,ee.hal.model.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="menu.html"></jsp:include>

<h1>Users List</h1>

<%
    List<Person> list=PersonDao.getAllRecords();
    request.setAttribute("list",list);
%>

<table border="1" width="90%">
    <tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th>
        <th>Sex</th><th>Country</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach items="${list}" var="person">
        <tr><td>${person.getId()}</td><td>${person.getFirstName()}</td><td>${person.getPassword()}</td>
            <td>${person.getEmail()}</td><td>${person.getSex()}</td><td>${person.getCountry()}</td>
            <td><a href="edit_person.jsp?id=${person.getId()}">Edit</a></td>
            <td><a href="delete_person.jsp?id=${person.getId()}">Delete</a></td></tr>
    </c:forEach>
</table>
<br/><a href="add_person.jsp">Add New Person</a>
</body>
</html>