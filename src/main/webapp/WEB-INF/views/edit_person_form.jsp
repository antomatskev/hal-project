<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Form</title>
</head>
<body>
<%@page import="ee.hal.dao.PersonDao,ee.hal.model.Person" %>

<%
    String id = request.getParameter("id");
    Person person = PersonDao.getRecordById(Long.parseLong(id));
%>

<h1>Edit Form</h1>
<form action="edit_person.jsp" method="post">
    <input type="hidden" name="id" value="<%=person.getId() %>"/>
    <table>
        <tr>
            <td>Personal code:</td>
            <td>
                <input type="text" name="personalCode" value="<%= person.getPersonalCode()%>"/>
            </td>
        </tr>
        <tr>
            <td>First Name:</td>
            <td>
                <input type="text" name="name" value="<%= person.getFirstName()%>"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td>
                <input type="password" name="password" value="<%= person.getLastName()%>"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <input type="email" name="email" value="<%= person.getEmail()%>"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>
                <input type="email" name="email" value="<%= person.getAddress()%>"/></td>
        </tr>
        <tr>
            <td>Bank account:</td>
            <td>
                <input type="email" name="email" value="<%= person.getBankAccount()%>"/></td>
        </tr>
        <tr>
            <td>Insurance:</td>
            <td>
                <input type="email" name="email" value="<%= person.getInsurance()%>"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Edit Person"/></td>
        </tr>
    </table>
</form>

</body>
</html>