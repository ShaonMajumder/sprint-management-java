package UI;

import javax.swing.*;
import java.awt.*;

public class Home {
    public static void draw() {
        JFrame frame = new JFrame("Home");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Create the top panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        // Create the title label
        JLabel titleLabel = new JLabel("Home");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        topPanel.add(titleLabel, BorderLayout.WEST);

        // Create the buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Create the minimize button
        JButton minimizeButton = new JButton("-");
        minimizeButton.setFocusable(false);
        buttonsPanel.add(minimizeButton);

        // Create the maximize button
        JButton maximizeButton = new JButton("\u25A1");
        maximizeButton.setFocusable(false);
        buttonsPanel.add(maximizeButton);

        // Create the close button
        JButton closeButton = new JButton("X");
        closeButton.setFocusable(false);
        buttonsPanel.add(closeButton);

        // Add the buttons panel to the top panel
        topPanel.add(buttonsPanel, BorderLayout.EAST);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create the "Add New Project" button
        JButton addProjectButton = new JButton("Add New Project \u2192");
        mainPanel.add(addProjectButton);

        // Create the "Add New Task into Backlog" button
        JButton addTaskButton = new JButton("Add New Task into Backlog \u2192");
        mainPanel.add(addTaskButton);

        // Create the "Go To Projects List" button
        JButton projectsListButton = new JButton("Go To Projects List \u2192");
        mainPanel.add(projectsListButton);

        // Create the "Go To Tasks List" button
        JButton tasksListButton = new JButton("Go To Tasks List \u2192");
        mainPanel.add(tasksListButton);

        // Create the "Go To Sprint Entry" button
        JButton sprintEntryButton = new JButton("Go To Sprint Entry \u2192");
        mainPanel.add(sprintEntryButton);

        // Create the "Go To Sprint List" button
        JButton sprintListButton = new JButton("Go To Sprint List \u2192");
        mainPanel.add(sprintListButton);

        // Add the panels to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);
    }
}
