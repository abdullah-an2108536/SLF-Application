package utility;

import java.sql.*;

public class Utility {

	public String dburl = "jdbc:oracle:thin:@slfdatabase_high?TNS_ADMIN=/Users/abdullah/SLF/Wallet_SLFDatabase";
	public String user = "ADMIN";
	public String pass = "OraclePassword2023@";
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