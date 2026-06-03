package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateValue {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		String query = "UPDATE employee SET job_title ='Tester' WHERE id = 7;";
		
			try {
				//1. Load and register the Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Drivers loaded successfully!!!");
			}catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
				
			try {
				//2. Establish connection
				Connection con = DriverManager.getConnection(url, username, password);
				System.out.println("connection created");
				//3.Create Statement 
				Statement st = con.createStatement();
				//4.Execute Query
				int rows = st.executeUpdate(query);
				if(rows > 0) {
					System.out.println("Deletion successfylly "+ rows+" row(s) affected.");
				}else {
					System.out.println("Deletion failed...");
				}
				//5.process the result[here no result is returned]
				
				//6. close the connection
				con.close();
				System.out.println("Connection closed successfully");
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}

}
