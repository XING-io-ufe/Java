package Lesson5;

import javax.swing.*;
import java.awt.*;

public class StudentInfoApp {
    public static void main(String[] args) {
        // Main Frame
        JFrame frame = new JFrame("Student Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout(10, 10)); // Using BorderLayout for the main frame

        // Top Panel: Student General Information
        JPanel studentInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        studentInfoPanel.setBorder(BorderFactory.createTitledBorder("Student General Information"));
        studentInfoPanel.add(new JLabel("Name:"));
        studentInfoPanel.add(new JTextField(15));
        studentInfoPanel.add(new JLabel("ID:"));
        studentInfoPanel.add(new JTextField(10));
        studentInfoPanel.add(new JLabel("Class:"));
        studentInfoPanel.add(new JTextField(10));
        frame.add(studentInfoPanel, BorderLayout.NORTH);

        // Left Panel: Selected Subjects
        JPanel subjectsPanel = new JPanel(new BoxLayout(new JPanel(), BoxLayout.Y_AXIS));
        subjectsPanel.setBorder(BorderFactory.createTitledBorder("Selected Subjects"));
        subjectsPanel.add(new JCheckBox("Math"));
        subjectsPanel.add(new JCheckBox("Physics"));
        subjectsPanel.add(new JCheckBox("Biology"));
        subjectsPanel.add(new JCheckBox("History"));
        frame.add(subjectsPanel, BorderLayout.WEST);

        // Center Panel: Teachers' Information
        JPanel teachersPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        teachersPanel.setBorder(BorderFactory.createTitledBorder("Teachers' Information"));
        teachersPanel.add(new JLabel("Math Teacher:"));
        teachersPanel.add(new JTextField(15));
        teachersPanel.add(new JLabel("Physics Teacher:"));
        teachersPanel.add(new JTextField(15));
        teachersPanel.add(new JLabel("Biology Teacher:"));
        teachersPanel.add(new JTextField(15));
        frame.add(teachersPanel, BorderLayout.CENTER);

        // Right Panel: Schedule
        JPanel schedulePanel = new JPanel(new GridBagLayout());
        schedulePanel.setBorder(BorderFactory.createTitledBorder("Class Schedule"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        schedulePanel.add(new JLabel("Day"), gbc);

        gbc.gridx = 1;
        schedulePanel.add(new JLabel("Time"), gbc);

        gbc.gridx = 2;
        schedulePanel.add(new JLabel("Subject"), gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        schedulePanel.add(new JLabel("Monday"), gbc);

        gbc.gridx = 1;
        schedulePanel.add(new JTextField(10), gbc);

        gbc.gridx = 2;
        schedulePanel.add(new JTextField(10), gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        schedulePanel.add(new JLabel("Tuesday"), gbc);

        gbc.gridx = 1;
        schedulePanel.add(new JTextField(10), gbc);

        gbc.gridx = 2;
        schedulePanel.add(new JTextField(10), gbc);

        frame.add(schedulePanel, BorderLayout.EAST);

        // Bottom Panel: Action Buttons
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        actionPanel.add(new JButton("Save"));
        actionPanel.add(new JButton("Cancel"));
        frame.add(actionPanel, BorderLayout.SOUTH);

        // Display the Frame
        frame.setVisible(true);
    }
}
