<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HAL person</title>
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
<center>
    <h2>HTTP Header Request Example</h2>
    <table width="100%" border="1" align="center">
        <tr bgcolor="#949494">
            <th>Param Name</th>
            <th>Param Value(s)</th>
        </tr>
        <%
            Enumeration paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                out.print("<tr><td>" + paramName + "</td>\n");
                String paramValue = request.getHeader(paramName);
                out.println("<td> " + paramValue + "</td></tr>\n");
            }
        %>
    </table>
</center>
</body>
</html>