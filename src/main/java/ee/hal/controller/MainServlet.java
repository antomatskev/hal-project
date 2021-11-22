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
@WebServlet("/")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 4L;

    private PersonDao personDao = new PersonDao();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/main.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/person_details.jsp");
//        dispatcher.forward(request, response);
//    }

}
