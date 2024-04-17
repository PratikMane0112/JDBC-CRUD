
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

### Create (Add Participant)
```
Integer rows = CreateUser.create(username, password, name, email);
```
### Read (Fecth All Participant)
```
GetAllUsers.getAll(panel);
```
### Update (Update Participant)
```
Integer rowsUpdated = UpdateUser.update(username, name, email);
```
### Delete (Delete Participant)
```
Integer rowsDeleted = DeleteUser.delete(username);
```
