package ee.hal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ee.hal.model.Person;

public class PersonDao {

    private static final String INSERT_PERSON_SQL = "INSERT INTO person" +
            " (personalCode, firstName, lastName, address, email, bankAccount, insurance) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";
    private static final String UPDATE_PERSON_SQL = "update register set name=?,password=?,email=?,sex=?,country=? where id=?";
    private static final String DELETE_PERSON_SQL = "delete from register where id=?";
    private static final String ALL_PERSONS_SQL = "select * from register";
    private static final String RECORD_BY_PERSON_ID_SQL = "select * from register where id=?";

    public static int registerPerson(Person person) throws ClassNotFoundException {
        int result = 0;
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq", "xxpiazwq", "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON_SQL)) {
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

    public static int update(Person person) throws ClassNotFoundException {
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
        int status = 0;
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq", "xxpiazwq", "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX");
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON_SQL)) {
            preparedStatement.setLong(1, person.getId());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return status;
    }

    public static List<Person> getAllRecords() {
        List<Person> list = new ArrayList<Person>();
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq", "xxpiazwq", "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX");
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_PERSONS_SQL)) {
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

    public static Person getRecordById(Long id) {
        Person person = null;
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq", "xxpiazwq", "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX");
             PreparedStatement preparedStatement = connection.prepareStatement(RECORD_BY_PERSON_ID_SQL)) {
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