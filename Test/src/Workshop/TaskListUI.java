package Workshop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskListUI extends JFrame {
    private JPanel taskListPanel;
    private JPanel taskDetailsPanel;
    private JPanel buttonPanel;
    private JTextArea taskDetailsArea;
    private JList<String> taskList;
    private DefaultListModel<String> taskListModel;

    public TaskListUI() {
        super("Task List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Create the task list panel
        taskListPanel = new JPanel();
        taskListPanel.setLayout(new BorderLayout());

        // Create the task details panel
        taskDetailsPanel = new JPanel();
        taskDetailsPanel.setLayout(new BorderLayout());
        taskDetailsPanel.setBorder(BorderFactory.createTitledBorder("Ажил нэмэх"));

        // Create a text area for task details
        taskDetailsArea = new JTextArea();
        taskDetailsArea.setLineWrap(true);
        taskDetailsArea.setWrapStyleWord(true);
        JScrollPane detailsScrollPane = new JScrollPane(taskDetailsArea);
        taskDetailsPanel.add(detailsScrollPane, BorderLayout.CENTER);

        // Create a button for adding a new task
        JButton addTaskButton = new JButton("Шинээр ажил нэмэх");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskDetails = taskDetailsArea.getText();
                if (!taskDetails.isEmpty()) {
                    taskListModel.addElement(taskDetails);
                    taskDetailsArea.setText(""); // Clear the text area
                }
            }
        });
        taskDetailsPanel.add(addTaskButton, BorderLayout.SOUTH);

        // Create the button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Create buttons for saving tasks
        JButton saveToDatabaseButton = new JButton("Баазад хадгалах");
        JButton saveToFileButton = new JButton("Файлд хадгалах");
        buttonPanel.add(saveToDatabaseButton);
        buttonPanel.add(saveToFileButton);

        // Create the task list model and list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane taskListScrollPane = new JScrollPane(taskList);
        taskListPanel.add(taskListScrollPane, BorderLayout.CENTER);

        // Add the panels to the frame
        add(taskListPanel, BorderLayout.WEST);
        add(taskDetailsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskListUI();
            }
        });
    }
}