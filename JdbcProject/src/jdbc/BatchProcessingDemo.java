package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		
		//1.load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Drivers loaded successfully.");
		
		//2.Establish connection 
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Establish Successfully.");
		//3.Create a statement
		Statement st = con.createStatement();
		
		//set Auto-commit to false
		con.setAutoCommit(false);
		
		//create sql statemnt and add it to batch
		String sql = "INSERT INTO employee(id, name, job_title, salary) VALUES (23,'dev','HR',45000);";
		st.addBatch(sql);
		
		//create one more sql statemnt and add it to batch
		sql = "INSERT INTO employee(id, name, job_title, salary) VALUES (24,'harii','Sr.HR',65000);";
		st.addBatch(sql);
		//create one more sql statemnt and add it to batch
		sql = "UPDATE employee set salary = 55000 where id = 24;";
		
		//execute the batch
		st.executeBatch();
		
		//commit to apply changes
		con.commit();

	}

}
