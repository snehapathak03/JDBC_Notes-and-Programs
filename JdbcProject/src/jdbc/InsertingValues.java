package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertingValues {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/Students";
			String username = "root";
			String password = "sona@2003";
			//1. Load and register the Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drivers loaded successfully!!!");
			//2. Establish connection
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connection created");
			//3.Create Statement 
			Statement st = con.createStatement();
			//4.Execute Query
			int rows = st.executeUpdate("insert into employee (id,name,job_title,salary) values(5,'sheela','cloud engg',90000.00)");
			if(rows == 0) {
				System.out.println("Insertion failed");
			}else {
				System.out.println(rows+" User detail inserted.");
			}
			//5.process the result[here no result is returned]
			
			//6. close the connection
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
