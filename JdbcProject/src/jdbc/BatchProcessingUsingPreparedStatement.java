package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessingUsingPreparedStatement {

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
		
		//3.create dynamic SQL statement
		String SQL = "INSERT INTO employee (id, name, job_title, salary) VALUES (?, ?, ?, ?);";
		
		//4.Create preparedStatement
		PreparedStatement ps = con.prepareStatement(SQL);
		
		//5.Set auto commit to false
		con.setAutoCommit(false);
		
		//to the dynamic query, setting different values and adding all os them to 
		//batch
		// so that all values can be inserted together into DB.
		// these values can be taken from user dynamically using Scanner.
		// Set the values to place holder position
		ps.setInt(1 , 11);
		ps.setString(2,"pops");
		ps.setString(3, "Helper");
		ps.setDouble(4, 20000);
		
		//Add it to the batch
		ps.addBatch();
		
		//Set new values to place holder position
		ps.setInt(1 , 12);
		ps.setString(2,"Damini");
		ps.setString(3, "Ass.Manager");
		ps.setDouble(4, 40000);
		ps.addBatch();
		
		//Set new values to place holder position
		ps.setInt(1 , 13);
		ps.setString(2,"JOy");
		ps.setString(3, "Sr.Manager");
		ps.setDouble(4, 70000);
		ps.addBatch();
		
		//Execute the batch //Execute the batch
		int[] result = ps.executeBatch();
		
		//commit to apply changes.
		con.commit();
		System.out.println("Changes commited successfully...");
		
		ps.close();
		con.close();
		System.out.println("Connections closed successfully...");

	}

}
