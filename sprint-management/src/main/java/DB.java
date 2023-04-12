import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sprint_management"; // Replace "mydatabase" with your database name
        String username = "shaon"; // Replace "root" with your MySQL username
        String password = "%Sh170892"; // Replace "mypassword" with your MySQL password

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver

            // Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Perform database operations here...

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
