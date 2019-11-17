package DAO;

import entity.Customer;

import java.net.ConnectException;
import java.sql.*;

public class CustomerDAO {

    private Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    public Customer getCustomer(int customersId) throws SQLException{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Customer customer = null;
        String sql = "SELECT * FROM customers WHERE customers_id = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customersId);
            resultSet = statement.executeQuery();

            customer = new Customer();
            while ( resultSet.next() ) {
                customer.setCustomersId(resultSet.getInt(1));
                customer.setCustomersName(resultSet.getString(2));
                customer.setCustomersAge(resultSet.getInt(3));
                customer.setCustomersBirthday(resultSet.getDate(4));
                customer.setCustomersZip(resultSet.getString(5));
                customer.setCustomersAddress(resultSet.getString(6));
                customer.setCustomersPhone(resultSet.getString(7));
                customer.setCustomersCreatedAt(resultSet.getDate(8));
                customer.setCustomersUpdatedAt(resultSet.getDate(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if ( resultSet != null ) {
                resultSet.close();
            }

            if ( statement != null ) {
                statement.close();
            }
        }
        return customer;
    }
}
