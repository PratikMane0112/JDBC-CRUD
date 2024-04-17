package GUI;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JDBC-CRUD");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Coding Competition Registration");
        titleLabel.setBounds(100, 10, 300, 25);
        panel.add(titleLabel);

        JButton addUserButton = new JButton("Add Participant");
        addUserButton.setBounds(30, 50, 150, 30);
        panel.add(addUserButton);

        JButton fetchUsersButton = new JButton("See All Participants");
        fetchUsersButton.setBounds(210, 50, 150, 30);
        panel.add(fetchUsersButton);

        JButton updateUserButton = new JButton("Update Participant");
        updateUserButton.setBounds(30, 100, 150, 30);
        panel.add(updateUserButton);

        JButton deleteUserButton = new JButton("Delete Participant");
        deleteUserButton.setBounds(210, 100, 150, 30);
        panel.add(deleteUserButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(130, 150, 100, 30);
        panel.add(exitButton);

        addUserButton.addActionListener(e -> {
            String username = JOptionPane.showInputDialog(panel, "Enter UserName:");
            String password = JOptionPane.showInputDialog(panel, "Enter Password:");
            String name = JOptionPane.showInputDialog(panel, "Enter Name:");
            String email = JOptionPane.showInputDialog(panel, "Enter Email:");

            if (username != null && password != null && name != null && email != null) {
                Integer rows = CreateUser.create(username, password, name, email);
                if (rows != 0) {
                    JOptionPane.showMessageDialog(panel, "Participant Added Successfully !!!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Participant Cannot be added, try again later");
                }
            }
        });

        fetchUsersButton.addActionListener(e -> {
            GetAllUsers.getAll(panel);
        });

        updateUserButton.addActionListener(e -> {
            String username = JOptionPane.showInputDialog(panel, "Enter UserName to update:");
            String name = JOptionPane.showInputDialog(panel, "Enter new Name:");
            String email = JOptionPane.showInputDialog(panel, "Enter new Email:");

            if (username != null && name != null && email != null) {
                Integer rowsUpdated = UpdateUser.update(username, name, email);
                if (rowsUpdated != 0) {
                    JOptionPane.showMessageDialog(panel, "Participant Updated Successfully !!!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Participant Cannot be updated, try again later");
                }
            }
        });

        deleteUserButton.addActionListener(e -> {
            String username = JOptionPane.showInputDialog(panel, "Enter UserName to delete:");
            if (username != null) {
                Integer rowsDeleted = DeleteUser.delete(username);
                if (rowsDeleted != 0) {
                    JOptionPane.showMessageDialog(panel, "Participant Deleted Successfully !!!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Participant Cannot be deleted, try again later");
                }
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
    }
}
