package Lesson7;
import java.sql.*;


public class ConnectDatabase {
    public ConnectDatabase() {
        Connection connection;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "0403";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                Statement statement = connection.createStatement();
//                statement.executeUpdate("CREATE TABLE testtable (id int primary key," + "name varchar(255)," + "address text)");
//                statement.close();
                String insertQuery = "INSERT INTO testtable VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, "odko");
                preparedStatement.setString(3, "chingeltei");
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
            } else{
                System.out.println("Failed to connect to database");
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new ConnectDatabase();
    }
}
