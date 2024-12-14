package Workshop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskManager extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    // Components
    private JTextField taskField;
    private JTextArea taskList;
    private JButton addTaskButton;
    private JButton saveToDatabaseButton;
    private JButton saveToFileButton;

    public TaskManager() {
        // Initialize JFrame
        super("Task Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for task input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        taskField = new JTextField(20);
        addTaskButton = new JButton("Нэмэх");
        addTaskButton.addActionListener(this);
        inputPanel.add(taskField);
        inputPanel.add(addTaskButton);

        // Panel for task list
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout());
        taskList = new JTextArea();
        taskList.setEditable(false);
        taskPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Panel for save buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        saveToDatabaseButton = new JButton("Баазад хадгалах");
        saveToDatabaseButton.addActionListener(this);
        saveToFileButton = new JButton("Файлд хадгалах");
        saveToFileButton.addActionListener(this);
        buttonPanel.add(saveToDatabaseButton);
        buttonPanel.add(saveToFileButton);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(taskPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTaskButton) {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                taskList.append(task + "\n");
                taskField.setText("");
            }
    } else if (e.getSource() == saveToDatabaseButton) {
        // Save to database logic here
        System.out.println("Saving to database...");
    } else if (e.getSource() == saveToFileButton) {
        // Save to file logic here
        System.out.println("Saving to file...");
    }
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new TaskManager();
        }
    });
}
}