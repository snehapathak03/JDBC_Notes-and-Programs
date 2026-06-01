import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuildConnection {
	
	public static void main(String[]args){
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		String query = "Select * from employee;";
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
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String job_title = rs.getString("job_title");
				double salary  = rs.getDouble("salary");
				System.out.println("==========================");
				System.out.println("ID: "+id);
				System.out.println("Name: "+name);
				System.out.println("Job title: "+job_title);
				System.out.println("salary: "+salary);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

}