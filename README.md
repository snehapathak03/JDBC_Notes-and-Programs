# JDBC_Notes-and-Programs
Notes and programs of jdbc 
<h1>JDBC</h1>
<p>stands for Java Database Connectivity- a powerful API that allows java program to access and manipulate data stored 
	in a wide varity of database.
	what is API: application programming interface.</p>

<h1>DEFINITION</h1>
<p>JDBC is an API that defines how a client can connect to a database,send SQL Queries and statements and retrieve 
	and manipulate the results.</p>

<h1>COMPONENTS</h1>
<p>JDBC consist of a set of interface and classes wirtten in java, a JDBC driver that venders implements to 
	comply the JDBC, and a database server that that supports JDBC.<br>
    Benefits:JDBC provides platform independence, security, and easy to use for java developers who need to access database.
	<br>JDBC Architecture:client -> Driver Manager -> Database Server </p>

<h3>Client:</h3>
<p>A JDBC client is any java application or applets that connects to a server-based database using JDBC API.<br>
Driver Manager:The DriverManager is a service of JDBC API that manages the driver and establish a connection 
	between a JDBC client and a Database server.<br>
	Database Server:A database server is a software program that provides database management functionality within a 
	networked computing environment.</p>
<br>
<h2>WHY TO USE JDBC:</h2> 
<p> 1]Interoperability: JDBC provides a universal API for accessing and interacting with any SQL-compliant
	database regardless of ventor.<br>
	2]Performance: JDBC allows application to cache data much more efficiently by facilitating the retrieval of multiple rows
	in one database operation.<br>
	3]Flexiblity: JDBC provides flexibility in choosing a vendor-specific or a vendor netural database management system, 
	allowing developers to adopt new technology easily.</p>
    <br>
    <h3>JDBC Drivers: There are 4 types of Drivers:</h3>
    <p>1]Type 1:JDBC-ODBC Bridge Driver.<br>
	2]Type 2:Native API Driver.<br>
	3]Type 3:Network Protocol Driver.<br>
	4]Type 4:Thin Driver.<br>
Type 1:JDBC-ODBC Bridge Driver<br>
This JDBC-ODBC brigde driver communicate with db, but it has some disadvantages like perform issur anf generally not been used in todays application.<br>
TYpe 2:Native API Driver<br>
Native API Driver provides a JDBC interface to specific db engine by translating JDBC calls into calls to db engine native library.<br>
Type 3:Network Protocol Driver<br>
it use client/server architecture which acts as a middleware "application server" that provides communication between JDBC client and the db server.<br>
Type 4: Thin Driver<br>
it is purely written in java and translates JDBC calls into network protocol calls and communicates directly with the db server,providing the best performance and scalability.<br>

in type 1 it has performance issur and written in c lang and ODBC driver is too old and type 3 needs middleware witch type 4 dont and type 2 while converting calls it gives some issue simply call as performance issue.<br></p>

<h4>JDBC COMPONENTS :</h4><p> there are so many components but we will seen only which is used commanly.<br>
1]Driver <br>
2]Driver Manager(DriverManager IS A CLASS ) <br>
3]Connerction(CONNECTION IS AN INTERFACE)<br>
4]Statement <br>
5]ResultSet<br>
6]SQL Exception <br>
<h6>*Driver Manager(DriverManager IS A CLASS ):</h6>
<p>The DriverManager class manages a list of db drivers.It establishes connections to the db using the appropriate driver and handles the process of loading the driver class.It provides a standardized method for handling multiple db connections and selecting the appropriate driver.</p>
<h6>Connerction(CONNECTION IS AN INTERFACE):</h6>
 <p>i]Creation of Statement: the connection interface is used to create a Statement obj, which is used to execute SQL queries against the db. <br>
 ii]Transaction Management: the connection interface allows transactions to be managed with methods such as commit() and rollback().<br>
iii]Retrieval of Metadata: the connection interface provides method to retrive metadata from the db, including info about the db structure and the various objects that are defined in it .</p>
<h6>Statement:</h6>
<p>i]Statement:the statement interface is used to execute simple SQL queries without parameters.<br>
ii]PreparedStatement:is used for executing precompiled sql queries with parameters,which can be more efficient and secure than Statement object.<br>
iii]CallableStatement:is used for executing db stored procedures.It provides a more efficient way to access them than with SQl statement.
</p>
<h6>ResultSet:</h6>
<p>i]Retrieving Data:the ResultSet interface is used to iterate through the rows of the result set and retrieve the data from the columns.<br>
ii]SCrolling Through Results:The ResultSet can be scrolled forwards and backwards to natigate through the results of the SQL query.<br>
iii]Modification of Data:the ResultSet allows modifications to the data within the db to be make,including insertion,deletion,and updates.
</p>
<h6>SQl Exception:</h6> 
<p>SQLException is an exception class that handles errors and exceptions related to db interactions. It provides information about the type of error that occurred,and allows for moreaccurate debugging and error resolution.</p></p>

<h5>EXCEPTION HANDLING jAVA:</h5> 
<p>Basically we have divides exception into two 1]Checked Exception and 2] Unchecked Exception <br>
i]Checked Exception:This are the exception which are checked at compile time.<br>
ii]Unchecked Exception:This are the exception which are not conformed at compile time but checked at runtime.</p><br>

<h2>Flow Chart:</h2>
<pre>
						Throwable
							|
	Exception									Error
		|								  		  |
	i]IOException								i]StackOverflowError
	ii]SQLException								ii]VirtualMachineError
	iii]ClassNotFoundException					iii]OutOfMemoryError
	iv]Runtime Exception						
			|
			i]ArithmeticException
			ii]NullPointerException
			iii]NumberFormatException
			iv]IndexOutOfBoundsException
						|
					i]ArrayIndexOutOfBoundsException
					ii]StringIndexOutOfBoundsException
</pre>

<h4>5 magical keywords</h4>
<pre>
	1]Try
	2]Catch
	3]Finally
	4]throw
	5]Throws
</pre>	
	
<pre>	
	1]TRY Catch 
	Before:
	import java.util.Scanner;
	public class ExceptionDemo{
		public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int divident = sc.nextInt();     //10
		int divisor = sc.nextInt();		 //0
		int result = divident/divisor;
		System.out.println("Your answer is : "+result);
		}
	}
	<h5>it will give ArithmeticException the message will be [Exception in thread "main" java. lang.ArithmeticException] </h5>
	<h5>After using try and catch:</h5>
	import java.util.Scanner;
	public class ExceptionDemo{
		public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int divident = sc.nextInt();     //10
		int divisor = sc.nextInt();		 //0
		try{
		int result = divident/divisor;
		System.out.println("Your answer is : "+result);
		}catch(ArithmeticException e){
		System.out.println("Divisor can't be 0!!!");
		}
		}
	}
</pre>
<h4>MULTIPLE TRY CATCH:</h4><pre>
	import java.util.Scanner;
	public class ExceptionDemo{
		public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int arr[] = new int [5];
		arr[6] = 10/0;    // here we will get two exceptions,first one arr[6] i.e ArrayIndexOutOfBoundsException and second 10/0 ArithmeticException 
		}
	}
	</pre>
	<pre>USE multiple try catch 
	import java.util.Scanner;
	public class ExceptionDemo{
		public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int arr[] = new int [5];
		try{
			arr[6] = 10/0;
			}
		catch(ArithmeticException e){
				System.out.println(e.getMessage());
				}
		catch(ArrayIndexOutOfBoundsException e){
				System.out.println(e.getMessage());
				}
		}
	}
	<i>output will be : /by zero </i>
	<i>And if we change arr[6] = 10; then it will give 'Index 6 out of bounds for length 5'.</i>
	</pre>
	<h5>NESTED TRY CATCH:</h5><pre>
	public class ExceptionDemo{
		public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];		
		try{
		System.out.println("I am in first try block!");
		try{
			arr[6]= 10;
		}catch(Exception e){				// when u dont know which exception is going to given just use the super class os that exception.
		System.out.println(e.getMessage());
		}
		}catch(Exception e){
		System.out.println(e.getMessage());
		}
		}
	} </pre>
	<pre>KEYWORD | DESCRIPTION 
	try		| The 'try' keyword is used to specify a block where we should place an exception code. It means we can't
              use try block alone.The try block must be followed by either catch or finally.
	catch	| The 'catch' block is used to handle the exception.It must be preceded by try block which means we can't
			  use catch block alone.It can be followed by finally block later.	
	finally	| The 'finally' block is used to execute the necessary code of the program.It is executed wether an exception
			  is handled or not.
	throw	| The 'throw' keywordis used to throw an exception.
	throws	| The 'throws' keyword is used to declare exceptions.It specifices that there may occur an exception in the method.
			  It doesn't throw an exception.It is always used with method signature.
	</pre>
	<h5>THROW</h5>
<pre>
		public class Demo{
		public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int age = s.nextInt();
		if(age< 18){
		System.out.println("Sorry you are not eligible!");
		}else{
		System.out.println("You are eligible");
		}
		}
	} 
	BUT WHEN U HAVE TO THROW EXCEPTION THEN:
	public class Demo{
		public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int age = s.nextInt();
		if(age< 18){
		throw new RuntimeException("Sorry you are not eligible!");
		}else{
		System.out.println("You are eligible");
		}
		}
	}</pre>
	<h5>THROWS:</h5><pre>
	public class Exception{
		public static void divisionDemo(int divident, int divisior){
		println("The result id :"+divident/divisior);
		}
		public static void main(String[]args){
		divisionDemo(divident:10, divisior:0);
		}
	}
	<i><u>output:it will give exception 
	Exception in thread "main" java.lang.ArithmeticException</u></i></pre>
	<p>------------------------------------------------------------------------------------------------</p>
	<pre>
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	public class Example {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// Step 1:Register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step2:Establish the Connection
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("connection created");
	}</pre><p>	
	[This is the first step towards jdbc, start writing with step1 , that is to register the driver i.e Class.forName(url),here 
	it will give classNotFoundException for that use throws and add classNotFoundException anf now step2
	here we have to establish the connection]</p>
	<p>step 1: open 'MySQL commant line client' in that <br>
			->show databases;<br>
			->create database sneha_db;<br>
			->use database sneha_db;<br>
			->create table table_name(col1,col2);<br>
	step 2: Once the table is created go back to eclips.</p>
	<h3>CONNECT JAVA TO MYSQL:</h3>
	<h5>TYPE 1:</h5><pre>
	package jdbc;
	import java.sql.Connection;	
	import java.sql.DriverManager;
	import java.sql.SQLException;
	public class Example {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// Step 1:Register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step2:Establish the Connection
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("connection created");
	}
}</pre>
	<h5>TYPE 2:</h5><pre>
	import java.sql.*;
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
}</pre>
<h3>PROGRAM:</h3>
	<pre>public static void main(String[]args){
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
	}</pre>
	<p>OUTPUT:<br>
	Drivers loaded successfully!!!<br>
	connection Established Successfullt!!<br>
	==========================<br>
	ID: 1<br>
	Name: kunal<br>
	Job title: software engg<br>
	salary: 75000.0<br>
	==========================<br>
	ID: 2<br>
	Name: Shushi<br>
	Job title: Developer<br>
	salary: 75000.0<br>
	==========================<br>
	ID: 3<br>
	Name: Kush<br>
	Job title: Manager<br>
	salary: 95000.0</p>
	<p>There are 5 steps to connect any java application with the
	database using JDBC. These steps are as follows :<br>
	1. Load and register Driver<br>
	2. Establish connection<br>
	3. Create a Statement<br>
	4. Execute the query<br>
	5. Process the result<br>
	6. Close the connection</p>
	<p><h5>TO ESTABLISH CONNECTION WITH DB[Here, we are connecting with mydb Database.]</h5>
	import java.sql.Connection;<br>
	import java.sql.DriverManager;<br>
	import java.sql.Exception;<br>
	public class EstablishConnection{<br>
		public static void main(String[] args){<br>
		//1.Load and register the Driver<br>
		Class.forName();<br>
		//2.Establish connection<br>
		Connection con = DriverManager.getConnection(url, username, password);<br>
		System.out.println("Connection establish with mydb database.");<br>
		System.out.println(con);<br>
		}<br>
	}</p>
	<h3>CONNECTION BUILDING:</h3>
	<pre>
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

}</pre>
<h3>HOW TO INSERT VALUES:</h3>
<pre>public class InsertingValues {

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
}</pre>
<p><h3>TYPE 2: OF INSERTING DATA</h3><pre> 	
public class InsertValue {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/Students";
		String username = "root";
		String password = "sona@2003";
		String query = "INSERT INTO employee(id,name,job_title,salary) VALUES (4,'UV','intern',30000)";
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
}</pre>
	<h5><i>NOTE: WHENEVER YOU ARE TRYING TO RETRIVE DATA THAT TIME U WILL USE -> ResultSet rs = st.executeQuery(query);
			AND WHEN U WILL TRY TO INSERT DATA U WILL USE -> executeUpdate(query);[here no resultset , here i 
			have to give variable for example int rowsAffected = st.executeUpdate(query); and condition 
			will be applied similar as above]</h5></p>
<p><h3>HOW TO DELETE THE VALUE :</h3>
	<h5>TYPE 1:</h5><pre> 
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
}</pre></p>			
<h3>TYPE 2:</h3>
<pre>	public class DeletingValues {
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			// Step 1: Load and register the Driver
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
			int rows = st.executeUpdate("delete from employee where job_title = 'CEO'");
			if(rows == 0 ) {
				System.out.println("Entered data isn't valid ");
			}else {
				System.out.println("User details are Deleted...");
			}
			//Step 5:process the result
			//Step 6: Close connection
			st.close();
			con.close();
			System.out.println("Connections closed successfully!!!!");
		}
	}</pre>
	<h3>HOW TO UPDATE VALUE</h3> 
	<h5>TYPE 1:</h5><pre>
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
		}</pre>
<h5>	TYPE 2:</h5><pre>
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
}</pre>	
<h3>TO FETCH AND DISPLAY VALUES FROM DB</h3><pre>
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
}</pre>
<p><h3>PREPARED STATEMENT:</h3>
	Prepared statements are a feature in database programming, commanly used in JDBC and other data access libraries.<br>
	They are used to execute Sql Wueries with placeholders for parameters. These placeholders are then filled with <br>
	specific values when the query is executed.<br>
	They offer serval advantages:<br>
	1. Protection against SQL injection.<br>
	2. Improved Performance.<br>
	3. Code Readability and Maintainability.<br>
	4. Automatic Data Type HANDLING.<br>
	5. Portability   etc.....</p>