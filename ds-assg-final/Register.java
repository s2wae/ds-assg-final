// Register.java

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Register {

    private static final String DATABASE = "users.txt";

    public void showPage() {
        JFrame frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(registerButton);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (!username.isEmpty() && !password.isEmpty()) {
                saveUser(username, password);
                JOptionPane.showMessageDialog(frame, "Registered successfully!");
                frame.dispose();
                new WelcomePage().showPage();
            } else {
                JOptionPane.showMessageDialog(frame, "All fields are required!");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void saveUser(String username, String password) {
        try (FileWriter writer = new FileWriter(DATABASE, true)) {
            writer.write(username + ":" + password + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving user: " + e.getMessage());
        }
    }
}
