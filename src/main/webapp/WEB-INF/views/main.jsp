<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HAL main</title>
</head>
<body>
<%--<jsp:include page="menu.html"></jsp:include>--%>
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
    <li><a href="views/person.jsp">Persons</a>
    <li><a href="/HAL-project/person/register">Person registration</a>
    <li><a href="/HAL-project/sl/all">Sick leaves</a>
    <li><a href="/HAL-project/sl/register">New sick leave</a>
    <li><a href="/HAL-project/payments/all">Payments</a>
</ul>

</body>
</html>