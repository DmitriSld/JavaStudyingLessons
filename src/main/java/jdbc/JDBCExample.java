package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {


    public static void main(String[] args) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;database=education_r09",
                "sa", "Q1w2e3r4t%")) {
            //Statement statement = connection.createStatement();
            //PreparedStatement preparedStatement = connection.prepareStatement("SELECT TOP 10 * FROM WM_PERSONAL_CARD");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TOP 10 * FROM WM_PERSONAL_CARD AS WPC WHERE ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("A_NAME"));
            }
        }

    }
}

