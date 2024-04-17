package GUI;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class GetAllUsers {
    public static void getAll(JPanel panel) {
        Connection con = null;
        try {
            con = Configuration.createConnection();

            String allUsersQuery = "SELECT * FROM users";
            PreparedStatement st = con.prepareStatement(allUsersQuery);

            ResultSet rs = st.executeQuery();

            // Create a table model and add columns
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Participant ID");
            tableModel.addColumn("Username");
            tableModel.addColumn("Password");
            tableModel.addColumn("Full Name");
            tableModel.addColumn("Email");

            // Populate the table model with data from the result set
            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getLong(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString("password");
                row[3] = rs.getString(4);
                row[4] = rs.getString("email");
                tableModel.addRow(row);
            }

            // Create and display the table
            JTable table = new JTable(tableModel);
            JOptionPane.showMessageDialog(panel, new JScrollPane(table), "All Participants", JOptionPane.PLAIN_MESSAGE);

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
    }
}
