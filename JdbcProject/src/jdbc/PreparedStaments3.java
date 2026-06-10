package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStaments3 {

	public static void main(String[] args) {
				
				String url = "jdbc:mysql://localhost:3306/Students";
				String username = "root";
				String password = "sona@2003";
				String query = "INSERT INTO employee(id, name, job_title, salary) VALUES (?, ?, ?, ?);";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Drivers loaded successfully.");
				}catch(ClassNotFoundException e) {
					System.out.println(e.getMessage());
				}

				try {
					Connection con = DriverManager.getConnection(url, username, password);
					System.out.println("Connection Establish Successfully.");
					//Statement st = con.createStatement();
					
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, 15);
					ps.setString(2, "sheela");
					ps.setString(3, "Project Manager");
					ps.setDouble(4, 98000.00);
					
					int rowsAffected = ps.executeUpdate();
					if(rowsAffected > 0) {
						System.out.println("Data inserted successfully");
					}else {
						System.out.println("Data inserted failed");
					}
					ps.close();
					con.close();
					System.out.println();
					System.out.println("Connection closed Successfully.");
				}catch(SQLException e) {
					System.err.println(e.getMessage());
				}
		
	}

}
