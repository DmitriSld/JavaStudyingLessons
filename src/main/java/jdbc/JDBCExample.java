package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class JDBCExample {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("net.sourceforge.jtds.jdbc.Driver");
//        Driver driver = new com.mysql.jdbc.Driver();
//        //Class.forName("com.mysql.jdbc.Driver");
        //Driver d = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        //Driver driver = new com.mysql.jdbc.Driver();
        Driver driver = new net.sourceforge.jtds.jdbc.Driver();
        Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1434/education_r09",
                "sa", "Q1w2e3r4t%");

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
