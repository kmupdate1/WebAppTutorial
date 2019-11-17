package BussinessLogic;

import Entity.Customer;
import Integration.DAO.CustomerDAO;
import Integration.WatajuDBConnectionManager;

import java.sql.*;

public class SearchCustomerLogic {

    public Customer searchCustomer(int customersId){

        Connection connection = null;
        Customer customer = null;

        try {
            connection = WatajuDBConnectionManager.getConnection();

            CustomerDAO customerDAO = new CustomerDAO(connection);
            customer = customerDAO.getCustomer(customersId);
            if (customer == null) {
                throw new SalesSystemException("該当するお客様は、登録されていません。");
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。<br>連絡先:080-4303-6523");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。<br>連絡先:080-4303-6523");
            }
        }
        return customer;
    }
}
