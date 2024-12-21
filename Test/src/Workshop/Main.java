package Workshop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;

public class Main {
    public static class ConnectDatabase {
        private Connection connection;

        public ConnectDatabase() {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "0403";

            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);

                if (connection == null) {
                    System.out.println("Failed to connect to the database");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        public void saveData(String task) {
            if (connection != null) {
                try {
                    String insertQuery = "INSERT INTO work (name) VALUES (?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setString(1,task);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Баазад хадгалахад алдаа гарлаа.");
                    e.printStackTrace();
                }
            }
        }
        // Ажлуудыг баазаас авах
        public void syncData(JPanel taskListPanel) {
            if (connection != null) {
                try {
                    String selectQuery = "SELECT name FROM work"; // Бүх ажлуудыг авах
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(selectQuery);

                    while (resultSet.next()) {
                        String task = resultSet.getString("name");
                        JLabel taskLabel = new JLabel(task);
                        taskLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                        taskListPanel.add(taskLabel);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Базын өгөгдлийг авахад алдаа гарлаа.");
                    e.printStackTrace();
                }
            }
        }

        public void closeConnection() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Үндсэн цонх үүсгэх
        JFrame frame = new JFrame("Ажлын Жагсаалт");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        // BorderLayout ашиглах
        frame.setLayout(new BorderLayout());

        // Зүүн талын багана (Хийх ажлын жагсаалт)
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 100)
        ));

        JLabel leftTitle = new JLabel("Хийх ажлын жагсаалт");
        leftPanel.add(leftTitle);

        JPanel taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));
        taskListPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,0));

        leftPanel.add(taskListPanel);

        JPanel buttonPanel = new JPanel();

        JButton saveToDatabaseButton = new JButton("Баазад хадгалах");
        JButton saveToFileButton = new JButton("Файлд хадгалах");
        buttonPanel.add(saveToDatabaseButton);
        buttonPanel.add(saveToFileButton);

        leftPanel.add(saveToDatabaseButton);
        leftPanel.add(saveToFileButton);

        //right
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel rightTitle = new JLabel("Ажил нэмэх");
        rightPanel.add(rightTitle);

        JLabel addTaskLabel = new JLabel("Ажлын тухай бичнэ үү");
        rightPanel.add(addTaskLabel);

        JTextArea textArea = new JTextArea(5,10);
        JScrollPane scrollPane = new JScrollPane(textArea);
        rightPanel.add(scrollPane);

        JButton addTaskButton = new JButton("Шинэ ажил нэмэх");
        rightPanel.add(addTaskButton);

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskDetails = textArea.getText();
                if (!taskDetails.isEmpty()) {
                    JLabel taskLabel = new JLabel(taskDetails);
                    taskLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    taskListPanel.add(taskLabel);
                    textArea.setText(""); // Clear the text area
                    frame.revalidate();
                }
            }
        });

        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Файл хадгалах диалог үүсгэх
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Файл хадгалах");

                int userSelection = fileChooser.showSaveDialog(frame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                        // Ажлын жагсаалт хадгалах
                        for (Component comp : taskListPanel.getComponents()) {
                            if (comp instanceof JLabel) {
                                JLabel taskLabel = (JLabel) comp;
                                writer.write(taskLabel.getText());
                                writer.newLine(); // Шинэ мөр
                            }
                        }
                        JOptionPane.showMessageDialog(frame, "Файлд амжилттай хадгаллаа.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Хадгалах үед алдаа гарлаа.");
                    }
                }
            }
        });

        saveToDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Баазад хадгалахын тулд connectDatabase объект үүсгэнэ
                ConnectDatabase connectDatabase = new ConnectDatabase();

                // Үүнийг "taskListPanel" -ээс авах
                for (Component comp : taskListPanel.getComponents()) {
                    if (comp instanceof JLabel) {
                        JLabel taskLabel = (JLabel) comp;
                        String task = taskLabel.getText();
                        connectDatabase.saveData(task); // Save each task to the database
                    }
                }
                connectDatabase.closeConnection(); // Close the database connection after saving
            }
        });
        ConnectDatabase connectDatabase = new ConnectDatabase();
        connectDatabase.syncData(taskListPanel);
        connectDatabase.closeConnection();


        // Эдгээрийг BorderLayout-д нэмэх
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);

        // Цонхыг харуулах
        frame.setVisible(true);
    }
}
