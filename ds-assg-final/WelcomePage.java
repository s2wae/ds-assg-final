import javax.swing.*;
import java.awt.*;

public class WelcomePage {

    public void showPage() {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            frame.dispose();
            SwingUtilities.invokeLater(() -> new Register().showPage());
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            frame.dispose();
            SwingUtilities.invokeLater(() -> new Login().showPage());
        });

        panel.add(registerButton);
        panel.add(loginButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
