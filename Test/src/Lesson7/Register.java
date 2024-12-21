package Lesson7;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Register {

    // Database connection details
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "0403";

    // Method to register the user
    public static void registerUser(String username, String password, String firstName, String lastName, String email) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String insertQuery = "INSERT INTO users (username, password,  first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, email);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registration Successful!");
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // Method to check login credentials
    public static boolean loginUser(String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String selectQuery = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    // Registration form
    public static void registerForm() {
        JFrame frame = new JFrame("Registration Page");
        frame.setLayout(null);
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel last = new JLabel("Last Name: ");
        JLabel first = new JLabel("First Name: ");
        JLabel mail = new JLabel("Email: ");
        JLabel name = new JLabel("Username: ");
        JLabel pass = new JLabel("Password: ");

        JTextField lastName = new JTextField();
        JTextField firstName = new JTextField();
        JTextField email = new JTextField();
        JTextField username = new JTextField();
        JTextField password = new JTextField();

        JButton rBtn = new JButton("Register");

        last.setBounds(10, 10, 100, 30);
        lastName.setBounds(10, 40, 200, 30);
        first.setBounds(10, 70, 100, 30);
        firstName.setBounds(10, 100, 200, 30);
        mail.setBounds(10, 130, 100, 30);
        email.setBounds(10, 160, 200, 30);
        name.setBounds(10, 190, 100, 30);
        username.setBounds(10, 220, 200, 30);
        pass.setBounds(10, 250, 100, 30);
        password.setBounds(10, 280, 200, 30);
        rBtn.setBounds(50, 340, 100, 30);

        frame.add(last);
        frame.add(lastName);
        frame.add(first);
        frame.add(firstName);
        frame.add(mail);
        frame.add(email);
        frame.add(name);
        frame.add(username);
        frame.add(pass);
        frame.add(password);
        frame.add(rBtn);
        frame.setVisible(true);

        rBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String last = lastName.getText();
                String first = firstName.getText();
                String mail = email.getText();
                String user = username.getText();
                String pass = password.getText();

                if (!mail.isEmpty() && !user.isEmpty() && !pass.isEmpty()) {
                    registerUser(user, pass, first, last, mail);
                    loginForm();
                } else {
                    JOptionPane.showMessageDialog(null, "All fields must be filled.");
                }
            }
        });
    }

    // Login form
    public static void loginForm() {
        JFrame frame = new JFrame("Login Page");
        frame.setLayout(null);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel name = new JLabel("Username: ");
        JLabel pass = new JLabel("Password: ");
        JTextField username = new JTextField();
        JTextField password = new JTextField();

        JButton lBtn = new JButton("Login");

        name.setBounds(10, 10, 100, 30);
        username.setBounds(10, 40, 200, 30);
        pass.setBounds(10, 70, 100, 30);
        password.setBounds(10, 100, 200, 30);
        lBtn.setBounds(50, 160, 100, 30);

        frame.add(name);
        frame.add(username);
        frame.add(pass);
        frame.add(password);
        frame.add(lBtn);
        frame.setVisible(true);

        lBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                String pass = password.getText();

                if (loginUser(user, pass)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    // Open the next page or window after successful login
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials, please try again.");
                }
            }
        });
    }

    public static void main(String[] args) {
        registerForm();
    }
}
