package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args)  {
		
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		String query = "DELETE from employee where job_title = 'CEO';";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("connection Established Successfullt!!");
			Statement st = con.createStatement();
			int rowsAffected = st.executeUpdate(query);
			if(rowsAffected > 0) {
				System.out.println("DELETE successfull. "+rowsAffected + "row(s) affected.");
			}else {
				System.out.println("DELETION failed.");
			}
			
			st.close();
			con.close();
			System.out.println();
			System.out.println("Connection closed Successfully!!");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
