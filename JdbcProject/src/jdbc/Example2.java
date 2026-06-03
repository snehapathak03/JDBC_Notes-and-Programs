package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example2 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drivers loaded successfully!!!");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connection Established Successfullt!!");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}

	}

}
