package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CreateUser {
    public static Integer create(String username, String password, String name, String email) {
        Connection con = null;
        Integer rowUpdated = 0;
        try {
            con = Configuration.createConnection();

            String insertQuery = "INSERT INTO users (username, password, fullname, email) VALUES(?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(insertQuery);

            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, name);
            st.setString(4, email);

            rowUpdated = st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rowUpdated;
    }
}