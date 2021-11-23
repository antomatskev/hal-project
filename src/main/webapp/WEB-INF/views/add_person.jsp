<%@page import="ee.hal.dao.PersonDao" %>
<jsp:useBean id="person" class="ee.hal.model.Person"></jsp:useBean>
<jsp:setProperty property="*" name="person"/>

<%
    int i = PersonDao.registerPerson(person);
    if (i > 0) {
        response.sendRedirect("add_person_success.jsp");
    } else {
        response.sendRedirect("add_person_error.jsp");
    }
%>