import javax.swing.*;
import java.io.*;
import java.util.*;

public class Login {

    private static final String DATABASE = "users.txt";

    public void showPage() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (validateUser(username, password)) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                frame.dispose();
                new SimpleDriveGUI().showGUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password!");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private boolean validateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading database: " + e.getMessage());
        }
        return false;
    }
}
