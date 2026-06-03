package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// Step 1:Register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step2:Establish the Connection
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("connection created");

	}
		        
}
