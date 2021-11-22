package ee.hal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ee.hal.model.Person;

public class PersonDao {

    public int registerPerson(Person person) throws ClassNotFoundException {
        String INSERT_PERSON_SQL = "INSERT INTO person" +
                " (personalCode, firstName, lastName, address, email, bankAccount, insurance) VALUES " +
                " (?, ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq", "xxpiazwq", "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON_SQL)) {
            preparedStatement.setString(1, person.getPersonalCode());
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

    public static int update(Person person) throws ClassNotFoundException {
        final String UPDATE_PERSON_SQL = "update register set name=?,password=?,email=?,sex=?,country=? where id=?";
        int result = 0;
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq", "xxpiazwq", "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX");
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON_SQL)) {
            preparedStatement.setString(1, person.getPersonalCode());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getAddress());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.setString(6, person.getBankAccount());
            preparedStatement.setString(7, person.getInsurance());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            System.gc();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public static int delete(Person person) {
        final String DELETE_PERSON_SQL = "delete from register where id=?";
        int status = 0;
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq", "xxpiazwq", "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX");
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON_SQL)) {
            PreparedStatement ps = connection.prepareStatement(DELETE_PERSON_SQL);
            ps.setLong(1, person.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return status;
    }

    public static List<Person> getAllRecords() {
        List<Person> list = new ArrayList<Person>();
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq", "xxpiazwq", "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX");
             PreparedStatement preparedStatement = connection.prepareStatement("select * from register")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getLong("id"));
                person.setPersonalCode(rs.getString("personalCode"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setAddress(rs.getString("address"));
                person.setEmail(rs.getString("email"));
                person.setBankAccount(rs.getString("bankAccount"));
                person.setInsurance(rs.getString("insurance"));
                list.add(person);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public static Person getRecordById(int id) {
        Person person = null;
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq", "xxpiazwq", "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX");
             PreparedStatement preparedStatement = connection.prepareStatement("select * from register where id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                person = new Person();
                person.setId(rs.getLong("id"));
                person.setPersonalCode(rs.getString("personalCode"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setAddress(rs.getString("address"));
                person.setEmail(rs.getString("email"));
                person.setBankAccount(rs.getString("bankAccount"));
                person.setInsurance(rs.getString("insurance"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return person;
    }

    private static void printSQLException(SQLException ex) {
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