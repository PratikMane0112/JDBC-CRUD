package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeleteUser {
    public static Integer delete(String username) {
        Connection con = null;
        Integer rowDeleted = 0;
        try {
            con = Configuration.createConnection();

            String deleteQuery = "DELETE FROM users WHERE username = ?";
            PreparedStatement st = con.prepareStatement(deleteQuery);
            st.setString(1, username);

            rowDeleted = st.executeUpdate();

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
        return rowDeleted;
    }
}