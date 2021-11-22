<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HAL incoming sick leaves</title>
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

<form action="http://localhost:8080/RegistrationSystem/CourseInserted.jsp" method="get">
    <h4></h4>
    <table>
        <tr>
            <td>Here we load the incoming sick leaves</td>

        <tr>
            <td>Person's First name</td>
        <tr>
            <td>Person's Last name</td>
        <tr>
            <td>Person's ID Code</td>
        <tr>
            <table>
</form>
</body>
</html>