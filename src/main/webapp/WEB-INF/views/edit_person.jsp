<%@page import="ee.hal.dao.PersonDao" %>
<jsp:useBean id="person" class="ee.hal.model.Person"></jsp:useBean>
<jsp:setProperty property="*" name="person"/>
<%
    try {
        int i = PersonDao.update(person);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    response.sendRedirect("person.jsp");
%>