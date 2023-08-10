package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Utility {

	public String dburl = "jdbc:sqlserver://slf-db-server.database.windows.net:1433;database=SLFdb";
	private static String user = "slfadmin";
	private static String pass = "slf@2023";
	public static Connection conn;
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

	public Utility() {
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

	public List<String> getUniqueVillages() {
		List<String> villages = new ArrayList<>();
		String query = "SELECT DISTINCT Village FROM BENEFICIARY"; // Replace with your table name
		try (
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				villages.add(resultSet.getString("Village"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villages;
	}

	public List<String> getUniqueCommunities() {
		List<String> communities = new ArrayList<>();
		String query = "SELECT DISTINCT CNAME FROM COMMUNITY"; // Replace with your table name
		try (
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				communities.add(resultSet.getString("CNAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return communities;
	}
	
	public List<String> getUniqueVaccinaters() {
		List<String> communities = new ArrayList<>();
		String query = "SELECT DISTINCT Vaccinater FROM Vaccination_Record"; // Replace with your table name
		try (
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				communities.add(resultSet.getString("Vaccinater"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return communities;
	}
	
	public List<String> getUniqueDonors() {
		List<String> communities = new ArrayList<>();
		String query = "SELECT DISTINCT donor FROM Vaccination_Record"; // Replace with your table name
		try (
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				communities.add(resultSet.getString("donor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return communities;
	}
	
	public List<String> getUniqueDvtype() {
		List<String> communities = new ArrayList<>();
		String query = "SELECT DISTINCT VaccinationType FROM Vrecord"; // Replace with your table name
		try (
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				communities.add(resultSet.getString("VaccinationType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return communities;
	}
	
	public List<String> getUniquePype() {
		List<String> communities = new ArrayList<>();
		String query = "SELECT DISTINCT PredatorType FROM Predation_Record"; // Replace with your table name
		try (
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				communities.add(resultSet.getString("PredatorType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return communities;
	}
	
	public List<String> getUniqueDtype() {
		List<String> communities = new ArrayList<>();
		String query = "SELECT DISTINCT DiseaseType FROM Disease_Record"; // Replace with your table name
		try (
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				communities.add(resultSet.getString("DiseaseType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return communities;
	}
}
