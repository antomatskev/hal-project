package ee.hal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ee.hal.model.Person;

public class PersonDao {

    private static Long id = 0L;

    public int registerPerson(Person person) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO person" +
                " (personal_code, first_name, last_name, address, email, bank_account, insurance) VALUES " +
                " (?, ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("injdbc:mysql://localhost:3306/employees?allowPublicKeyRetrieval=true&useSSL=false", "root", "Password123!");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setLong(1, id++);
            preparedStatement.setString(2, person.getPersonalCode());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getAddress());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.setString(6, person.getBankAccount());
            preparedStatement.setString(7, person.getInsurance());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            System.gc();
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}