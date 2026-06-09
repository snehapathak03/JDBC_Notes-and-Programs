package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStat {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		String query = "SELECT * FROM employee WHERE name = ? ;";
		
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
			ps.setString(1, "UV");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				// left one is java variable and right one is database colum name 
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String job_title = rs.getString("job_title");
				double salary = rs.getDouble("salary");
				System.out.println("ID : "+id);
				System.out.println("NAME : "+name);
				System.out.println("JOB TITLE : "+job_title);
				System.out.println("SALARY : "+salary);
			}
			rs.close();
			ps.close();
			con.close();
			System.out.println();
			System.out.println("Connection closed Successfully.");
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}






















