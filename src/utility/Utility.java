package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utility {

    public String dburl = "jdbc:sqlserver://slf-db-server.database.windows.net:1433;database=SLFdb";
    public String user;
    public String pass;
    public Connection conn;
    public ResultSet rs;
    public Statement stmt;
    public PreparedStatement pstmt;

    public Utility(String user, String pass) {
        this.user = user;
        this.pass = pass;

        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Modify the JDBC URL to include the user and password
            String completeDbUrl = dburl + ";user=" + user + ";password=" + pass
                    + ";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

            // Establish the connection using the modified JDBC URL
            conn = DriverManager.getConnection(completeDbUrl);

            if (conn != null) {
                System.out.println("Connected to the database!");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public void terminate() {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    // Add other methods for database operations as needed
}

