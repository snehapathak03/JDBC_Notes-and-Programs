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

<h3>Client:A JDBC client is any java application or applets that connects to a server-based database using JDBC API.<br>
Driver Manager:The DriverManager is a service of JDBC API that manages the driver and establish a connection 
	between a JDBC client and a Database server.<br>
	Database Server:A database server is a software program that provides database management functionality within a 
	networked computing environment.</h3>
<br>
<h2>WHY TO USE JDBC:</h2> <br>
<p> 1]Interoperability: JDBC provides a universal API for accessing and interacting with any SQL-compliant
	database regardless of ventor.
	2]Performance: JDBC allows application to cache data much more efficiently by facilitating the retrieval of multiple rows
	in one database operation.
	3]Flexiblity: JDBC provides flexibility in choosing a vendor-specific or a vendor netural database management system, 
	allowing developers to adopt new technology easily.</p>
    <br><br>
    <h3>JDBC Drivers: There are 4 types of Drivers:</h3><br>
    <p>1]Type 1:JDBC-ODBC Bridge Driver.<br>
	2]Type 2:Native API Driver.<br>
	3]Type 3:Network Protocol Driver.<br>
	4]Type 4:Thin Driver.<br>
Type 1:JDBC-ODBC Bridge Driver<br>
This JDBC-ODBC brigde driver communicate with db, but it has some disadvantages like perform issur anf generally not been used in todays application.<br><br>
TYpe 2:Native API Driver<br>
Native API Driver provides a JDBC interface to specific db engine by translating JDBC calls into calls to db engine native library.<br><br>
Type 3:Network Protocol Driver<br>
it use client/server architecture which acts as a middleware "application server" that provides communication between JDBC client and the db server.<br><br>
Type 4: Thin Driver<br>
it is purely written in java and translates JDBC calls into network protocol calls and communicates directly with the db server,providing the best performance and scalability.<br><br>

in type 1 it has performance issur and written in c lang and ODBC driver is too old and type 3 needs middleware witch type 4 dont and type 2 while converting calls it gives some issue simply call as performance issue.<br><br></p>

<h4>JDBC COMPONENTS :</h4><br><p> there are so many components but we will seen only which is used commanly.<br>
1]Driver
2]Driver Manager(DriverManager IS A CLASS )
3]Connerction(CONNECTION IS AN INTERFACE)
4]Statement 
5]ResultSet
6]SQL Exception
<h6>*Driver Manager(DriverManager IS A CLASS ):</h6><br>
<p>The DriverManager class manages a list of db drivers.It establishes connections to the db using the appropriate driver and handles the process of loading the driver class.It provides a standardized method for handling multiple db connections and selecting the appropriate driver.</p><br><br>
<h6>Connerction(CONNECTION IS AN INTERFACE):</h6><br>
 <p>i]Creation of Statement: the connection interface is used to create a Statement obj, which is used to execute SQL queries against the db. <br>
 ii]Transaction Management: the connection interface allows transactions to be managed with methods such as commit() and rollback().<br>
iii]Retrieval of Metadata: the connection interface provides method to retrive metadata from the db, including info about the db structure and the various objects that are defined in it .</p><br><br>
<h6>Statement:</h6><br>
<p>i]Statement:the statement interface is used to execute simple SQL queries without parameters.<br>
ii]PreparedStatement:is used for executing precompiled sql queries with parameters,which can be more efficient and secure than Statement object.<br>
iii]CallableStatement:is used for executing db stored procedures.It provides a more efficient way to access them than with SQl statement.
</p><br><br>
<h6>ResultSet:</h6><br>
<p>i]Retrieving Data:the ResultSet interface is used to iterate through the rows of the result set and retrieve the data from the columns.<br>
ii]SCrolling Through Results:The ResultSet can be scrolled forwards and backwards to natigate through the results of the SQL query.<br>
iii]Modification of Data:the ResultSet allows modifications to the data within the db to be make,including insertion,deletion,and updates.
</p><br><br>
<h6>SQl Exception:</h6> <br>
<p>SQLException is an exception class that handles errors and exceptions related to db interactions. It provides information about the type of error that occurred,and allows for moreaccurate debugging and error resolution.</p></p>

<h5>EXCEPTION HANDLING jAVA:</h5> <br> 
<p>Basically we have divides exception into 2 1]Checked Exception and 2] Unchecked Exception <br>
i]Checked Exception:This are the exception which are checked at compile time.<br>
ii]Unchecked Exception:This are the exception which are not conformed at compile time but checked at runtime.</p><br><br>

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