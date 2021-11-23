<%@page import="ee.hal.dao.PersonDao"%>
<jsp:useBean id="person" class="ee.hal.model.Person"></jsp:useBean>
<jsp:setProperty property="*" name="person"/>
<%
  PersonDao.delete(person);
  response.sendRedirect("person.jsp");
%>