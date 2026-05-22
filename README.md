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
