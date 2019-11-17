package DAO;

import entity.Customer;

import java.sql.*;

public class CustomersDAO {

    private Connection connection;
    private String server;
    private String userName;
    private String userPassword;

    public CustomersDAO(String server, String userName, String userPassword) {
        this.server = server;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public connect() throws SQLException {
        String serverURL = "jdbc:mysql://" + server + ":3306/flm";
        //接続のためのAPI利用
        connection = DriverManager.getConnection(serverURL, userName, userPassword);
    }

    public close() throws SQLException{
        if ( connection != null ) {
            connection.close();
        }
    }

    public Customer getCustomer(int customersId) throws SQLException{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Customer customer = null;
        String sql = "SELECT * FROM customers where customers_id=?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customersId);
            resultSet = statement.executeQuery();

            if ( resultSet.next() ) {
                customer = new Customer();
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
