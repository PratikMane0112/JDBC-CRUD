package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UpdateUser {
    public static Integer update(String username, String name, String email) {
        Connection con = null;
        Integer rowUpdated = 0;
        try {
            con = Configuration.createConnection();

            String updateQuery = "UPDATE users SET fullname = ?, email = ? where username = ?";
            PreparedStatement st = con.prepareStatement(updateQuery);

            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, username);

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

