package BussinessLogic;

import java.sql.*;

public class DataBaseUser {

    //JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/WatajuCustomerManagement";

    //Database credentials
    static final String USER_NAME = "ken";
    static final String USER_PASSWORD = "smiley";
    public boolean isValidUserLogin(String sUserName, String sUserPassword){
        boolean isValidUser = false;

        Connection connection = null;
        Statement statement = null;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Please wait for a moment.\nConnecting to Database...");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);

            System.out.println("Creating statement...");
            statement = connection.createStatement();

            sql = "SELECT * FROM user_name = \"" + sUserName + "\" AND user_password = \"" + sUserPassword + "\"";

            System.out.println(sql);

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                isValidUser = true;
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {

            }
            try {
                if ( connection != null ) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Closing Database Connection.\nGoodBye!");

        return isValidUser;
    }
}
