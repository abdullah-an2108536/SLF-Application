package utility;

import java.sql.*;

public class Utility {
	
	// Will replace with Properties
	public String dburl = "";
	public String user = "";
	public String pass = "";
	public Connection conn;
	public ResultSet rs;
	public Statement stmt;
	public PreparedStatement pstmt;

	public Utility(){
		try {
			conn = DriverManager.getConnection(dburl, user, pass);
			 if (conn != null) {
	                System.out.println("Connected to the database !");
	            } else {
	                System.out.println("Failed to connect to Database!");
	            }
		} catch (SQLException e) {
			 System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
	}

	public void terminate() {
		try {
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			 System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}

	}
	
	
}