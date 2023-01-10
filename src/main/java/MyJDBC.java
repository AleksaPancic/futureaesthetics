/*

import java.sql.*;

public class MyJDBC {
    public static void main(String args[]) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/futureaesthetics",
                "root",
                "MySql7220");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT category_id FROM categories");

        while(resultSet.next())
        {
            System.out.println(resultSet.getString("category_id"));
        }




    }

}

 */

