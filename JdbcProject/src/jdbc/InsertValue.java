package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValue {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		String query = "INSERT INTO employee(id,name,job_title,salary) VALUES (11,'sneha','CEO',10000000000)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drivers loaded successfully!!!");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connection Established Successfullt!!");
			Statement st = con.createStatement();
			int rowsAffected = st.executeUpdate(query);
			if(rowsAffected > 0) {
				System.out.println("Insert successfull. "+rowsAffected + "row(s) affected.");
			}else {
				System.out.println("insertion failed.");
			}
			st.close();
			con.close();
			System.out.println();
			System.out.println("Connection Closed Successfully!");
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
