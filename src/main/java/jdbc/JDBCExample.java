package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("net.sourceforge.jtds.jdbc.Driver");
//        Driver driver = new com.mysql.jdbc.Driver();
//        //Class.forName("com.mysql.jdbc.Driver");
        //Driver d = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        //Driver driver = new com.mysql.jdbc.Driver();
        //Driver driver = new net.sourceforge.jtds.jdbc.Driver();
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;database=education_r09",
                "sa", "Q1w2e3r4t%")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select 5");
            resultSet.next();
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
        }

    }
}
//        try (Connection connection = DriverManager.getConnection()) {
//
//        } catch (SQLException e) {
//
//        }


//        System.out.println("MySQL JDBC Connection Testing ~");
//        List<String> list = new ArrayList<>();
//        String SQL_SELECT = "Select * from list";
//        //try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:1434/education_r09", "sa"
//        try (Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1434/education_r09",
//                "sa", "Q1w2e3r4t%");
//             //PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
//             //ResultSet resultSet = preparedStatement.executeQuery();
//        ) {
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
