package UI;

import javax.swing.*;
import java.awt.*;
public class ProjectCreate extends JFrame {
    private JTextField nameField;
    private JTextArea descArea;
    private JButton submitBtn;
    private JButton returnBtn;

    public static void draw() {
        // Create JFrame
        JFrame frame = new JFrame("Project Entry");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create JPanel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Project Name label and input box
        JLabel projectNameLabel = new JLabel("Project Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(projectNameLabel, constraints);
        JTextField projectNameInput = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        panel.add(projectNameInput, constraints);

        // Description label and input box
        JLabel descriptionLabel = new JLabel("Description:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(descriptionLabel, constraints);
        JTextArea descriptionInput = new JTextArea(5, 20);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionInput);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        panel.add(descriptionScrollPane, constraints);

        // Submit and Return buttons
        JButton submitButton = new JButton("Submit");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.weighty = 0;
        panel.add(submitButton, constraints);
        JButton returnButton = new JButton("Return");
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(returnButton, constraints);

        // Add panel to frame and show frame
        frame.add(panel);
        frame.setVisible(true);
    }
}