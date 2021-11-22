<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HAL main</title>
</head>
<body>
 <table>
<tr>
    <td><a href="/HAL-project"><img width="50%" src="https://www.haigekassa.ee/sites/default/files/symboolika/hk_eng_cmyk.jpg"></a></td>
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

<form action="/CourseInserted.jsp" method="get">
    <h4>Search for a Person </h4>
    <table>
        <tr>
            <td>First name: </td>
            <td><input type="text" id="FirstName" name="FirstName"></td>


        </tr>
        <tr>
            <td>Last name: </td>
            <td><input type="text" id="LastName" name="LastName"></td>

        </tr>
        <tr>
            <td>Personal code:</td>
            <td><input type="text" id="PersonIdCode" name="PersonIDCode"><td></tr>
        <td>
            <button type="button">Search</button>
        </td>
        <table>
</form>

</body>
</html>