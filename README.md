
This project is a Java application for managing participants in a coding competition. It provides functionality to add, fetch, update, and delete participants from a database.

## Features

- Add new participants to the competition.
- Fetch all participants currently registered.
- Update participant information.
- Delete participants from the competition.
- Clean and intuitive user interface.

## Technologies Used

- Java
- MySQL
- JDBC
- Swing (for GUI)

## How to Use

1. Clone the repository to your local machine.
2. Set up a MySQL database using the provided SQL schema.
3. Configure the database connection details in the `Configuration.java` file.
4. Compile and run the `MainGUI.java` file to launch the application.
5. Use the buttons in the GUI to perform CRUD operations on participants.

## Database Schema

The database schema includes a table named `users` with the following columns:

- `id` (Primary Key)
- `username`
- `password`
- `fullname`
- `email`

## CRUD Operations

### Connect (Make connection with database)
```
try { 
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection con = DriverManager.getConnection( 
		"jdbc:mysql://localhost:3306/mydb", "username", 
		"password"); 
	System.out.println("Connection established."); 
} 
catch (Exception e) { 
	e.printStackTrace(); 
}

```
### Create (Add Participant)
```
try { 
String sql = "INSERT INTO table_name (column1, column2, column3) VALUES (?, ?, ?)"; 
PreparedStatement statement = con.prepareStatement(sql); 
statement.setString(1, "value1"); 
statement.setString(2, "value2"); 
statement.setInt(3, 123); 
statement.executeUpdate(); 
System.out.println("Record created."); 
} catch (SQLException e) { 
e.printStackTrace(); 
}

```
### Read (Fecth All Participant)
```
try { 
String sql = "SELECT column1, column2, column3 FROM table_name WHERE id = ?"; 
PreparedStatement statement = con.prepareStatement(sql); 
statement.setInt(1, 1); 
ResultSet result = statement.executeQuery(); 
if (result.next()) { 
	String column1 = result.getString("column1"); 
	String column2 = result.getString("column2"); 
	int column3 = result.getInt("column3"); 
	System.out.println("Column 1: " + column1); 
	System.out.println("Column 2: " + column2); 
	System.out.println("Column 3: " + column3); 
} 
} catch (SQLException e) { 
e.printStackTrace(); 
}

```
### Update (Update Participant)
```
try { 
String sql = "UPDATE table_name SET column1 = ?, column2 = ?, column3 = ? WHERE id = ?"; 
PreparedStatement statement = con.prepareStatement(sql); 
statement.setString(1, "new_value1"); 
statement.setString(2, "new_value2"); 
statement.setInt(3, 456); 
statement.setInt(4, 1); 
statement.executeUpdate(); 
System.out.println("Record updated."); 
} catch (SQLException e) { 
e.printStackTrace(); 
}

```
### Delete (Delete Participant)
```
try { 
String sql = "DELETE FROM table_name WHERE id = ?"; 
PreparedStatement statement = con.prepareStatement(sql); 
statement.setInt(1, 1); 
statement.executeUpdate(); 
System.out.println("Record deleted."); 
} catch (SQLException e) { 
e.printStackTrace(); 
}

```
