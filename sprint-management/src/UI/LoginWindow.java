import javax.swing.*;
import java.awt.*;

public class LoginWindow {
    public static void draw(String[] args) {
        JFrame frame = new JFrame("Login To The System");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);

        JLabel userLabel = new JLabel("User Name:");
        JTextField userText = new JTextField(20); // updated to set preferred size
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField(20); // updated to set preferred size

        JButton loginButton = new JButton("Login");

        c.gridx = 0;
        c.gridy = 0;
        panel.add(userLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(userText, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(passwordText, c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(loginButton, c);



        JPanel bottomPanel = new JPanel(new BorderLayout());


        frame.add(panel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
