package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatingValue {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Step 1: Load and register the Driver
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded successfully");
		
		//Step 2: Establish Connection
		
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		Connection con = DriverManager.getConnection(url,username,password);
		System.out.println("Connection Build Successfully!!");
		
		//Step 3: Create Statement
		
		Statement st = con.createStatement();
		
		//Step 4:execute query
		int rows = st.executeUpdate("UPDATE employee SET job_title = 'Intern' WHERE id = 4");
		if(rows == 0 ) {
			System.out.println("Entered data isn't valid ");
		}else {
			System.out.println("User details are Updated...");
		}
		
		//Step 5:process the result
	
		//Step 6: Close connection
		st.close();
		con.close();
		System.out.println("Connections closed successfully!!!!");
	}
}
