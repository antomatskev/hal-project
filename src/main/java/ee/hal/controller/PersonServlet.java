package ee.hal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ee.hal.dao.PersonDao;
import ee.hal.model.Person;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PersonDao personDao = new PersonDao();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/person_register.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String personalCode = request.getParameter("personalCode");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String bankAccount = request.getParameter("bankAccount");
        String insurance = request.getParameter("insurance");

        Person person = new Person(personalCode, firstName, lastName, address, email, bankAccount, insurance);
//        employee.setFirstName(firstName);
//        employee.setLastName(lastName);
//        employee.setUsername(username);
//        employee.setPassword(password);
//        employee.setContact(contact);
//        employee.setAddress(address);

        try {
            personDao.registerPerson(person);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/person_details.jsp");
        dispatcher.forward(request, response);
    }

}
