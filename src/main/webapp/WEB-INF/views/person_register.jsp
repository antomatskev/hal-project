<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>HAL registration</title>
</head>
<body>
<table>
    <tr>
        <td><a href="/HAL-project"><img width="50%"
                                        src="https://www.haigekassa.ee/sites/default/files/symboolika/hk_eng_cmyk.jpg"></a>
        </td>
        <td><h1> Sick leave reimbursement</h1>
        </td>
    </tr>
</table>
<ul>
    <li><a href="/HAL-project/person/all">Persons</a>
    <li><a href="/HAL-project/person/register">Person registration</a>
    <li><a href="/HAL-project/sl/all">Sick leaves</a>
    <li><a href="/HAL-project/sl/register">New sick leave</a>
    <li><a href="/HAL-project/payments/all">Payments</a>
</ul>
<div align="center">
    <h1>Person Register Form</h1>
    <form action="<%= request.getContextPath() %>/person/register" method="post">
        <table style="with: 80%">
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName"/></td>
            </tr>
            <tr>
                <td>Personal Code</td>
                <td><input type="text" name="personalCode"/></td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address"/></td>
            </tr>
            <tr>
                <td>Bank Account</td>
                <td><input type="text" name="bankAccount"/></td>
            </tr>
            <tr>
                <td>Insurance</td>
                <td><input type="text" name="insurance"/></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>