package UI;
import javax.swing.*;
import java.awt.*;

public class ProjectList extends JFrame {
    public ProjectList() {
        super("Project List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnNames = {"ID", "Name", "Description", "Actions"};
        Object[][] data = {
                {1, "Project A", "This is a description.", createButtonPanel("Edit", "Archive")},
                {2, "Project B", "This is another description.", createButtonPanel("Edit", "Archive")},
                {3, "Project C", "This is a third description.", createButtonPanel("Edit", "Archive")}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(new JButton("Add Another Project"));
        buttonPanel.add(new JButton("Return"));

        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    private static JPanel createButtonPanel(String button1Name, String button2Name) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton button1 = new JButton(button1Name);
        JButton button2 = new JButton(button2Name);

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        return buttonPanel;
    }

    public static void draw() {
        SwingUtilities.invokeLater(() -> new ProjectList());
    }
}
