package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchingValuesFromDB {

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
				//step 3: create a statement
				Statement st = con.createStatement();
				//Step 4: execute query 
				ResultSet rs = st.executeQuery("select * from employee");
				//step 5: process the result 
				while(rs.next()) {
					System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("job_title")+" "+rs.getInt("salary"));
					System.out.println("-----------------------------------");
				}
				//step 6: close connection
				con.close();
				System.out.println("Connection closed successfully!!");
	}

}
