package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Configuration {
    private final static String URL = "jdbc:mysql://localhost:3306/jdbc-crud";
    private final static String userName = "root";
    private final static String password = "";

    public static Connection createConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, userName, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
