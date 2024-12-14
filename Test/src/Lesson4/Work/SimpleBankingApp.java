package Lesson4.Work;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleBankingApp {
    private User[] users = new User[10];
    private int userCount = 0;

    public static void main(String[] args) {
        new SimpleBankingApp().start();
    }

    public void start() {
        new SignUpPage();
    }

    class User {
        String email, password;
        double balance;

        User(String email, String password) {
            this.email = email;
            this.password = password;
            this.balance = 0.0;
        }
    }

    class SignUpPage {
        SignUpPage() {
            JFrame frame = new JFrame("Sign Up");
            frame.setSize(300, 200);
            frame.setLayout(null);

            JTextField emailField = new JTextField();
            emailField.setBounds(100, 20, 160, 25);
            frame.add(new JLabel("Email:")).setBounds(20, 20, 80, 25);
            frame.add(emailField);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(100, 60, 160, 25);
            frame.add(new JLabel("Password:")).setBounds(20, 60, 80, 25);
            frame.add(passwordField);

            JButton signUpButton = new JButton("Sign Up");
            signUpButton.setBounds(100, 100, 100, 25);
            frame.add(signUpButton);

            JLabel messageLabel = new JLabel();
            messageLabel.setBounds(20, 130, 250, 25);
            frame.add(messageLabel);

            signUpButton.addActionListener(e -> {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (userCount < users.length) {
                    users[userCount++] = new User(email, password);
                    messageLabel.setText("Sign Up Successful!");
                    new SignInPage();
                    frame.dispose();
                } else {
                    messageLabel.setText("User  limit reached!");
                }
            });

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    class SignInPage {
        SignInPage() {
            JFrame frame = new JFrame("Sign In");
            frame.setSize(300, 200);
            frame.setLayout(null);

            JTextField emailField = new JTextField();
            emailField.setBounds(100, 20, 160, 25);
            frame.add(new JLabel("Email:")).setBounds(20, 20, 80, 25);
            frame.add(emailField);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(100, 60, 160, 25);
            frame.add(new JLabel("Password:")).setBounds(20, 60, 80, 25);
            frame.add(passwordField);

            JButton signInButton = new JButton("Sign In");
            signInButton.setBounds(100, 100, 100, 25);
            frame.add(signInButton);

            JLabel messageLabel = new JLabel();
            messageLabel.setBounds(20, 130, 250, 25);
            frame.add(messageLabel);

            signInButton.addActionListener(e -> {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                for (User  user : users) {
                    if (user != null && user.email.equals(email) && user.password.equals(password)) {
                        messageLabel.setText("Sign In Successful!");
                        new MainPage(user);
                        frame.dispose();
                        return;
                    }
                }
                messageLabel.setText("Invalid email or password!");
            });

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    class MainPage {
        private User user;

        MainPage(User user) {
            this.user = user;
            JFrame frame = new JFrame("Main Page");
            frame.setSize(300, 300);
            frame.setLayout(null);

            JButton checkBalanceButton = new JButton("Check Balance");
            checkBalanceButton.setBounds(50, 20, 200, 25);
            frame.add(checkBalanceButton);

            JButton depositButton = new JButton("Deposit");
            depositButton.setBounds(50, 60, 200, 25);
            frame.add(depositButton);

            JButton withdrawButton = new JButton("Withdraw");
            withdrawButton.setBounds(50, 100, 200, 25);
            frame.add(withdrawButton);

            JButton logoutButton = new JButton("Logout");
            logoutButton.setBounds(50, 140, 200, 25);
            frame.add(logoutButton);

            JLabel balanceLabel = new JLabel("Balance: " + user.balance);
            balanceLabel.setBounds(50, 180, 200, 25);
            frame.add(balanceLabel);

            checkBalanceButton.addActionListener(e -> {
                balanceLabel.setText("Balance: " + user.balance);
            });

            depositButton.addActionListener(e -> {
                String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
                if (amountStr != null) {
                    double amount = Double.parseDouble(amountStr);
                    user.balance += amount;
                    balanceLabel.setText("Balance: " + user.balance);
                }
            });

            withdrawButton.addActionListener(e -> {
                String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
                if (amountStr != null) {
                    double amount = Double.parseDouble(amountStr);
                    if (amount <= user.balance) {
                        user.balance -= amount;
                        balanceLabel.setText("Balance: " + user.balance);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Insufficient balance!");
                    }
                }
            });

            logoutButton.addActionListener(e -> {
                frame.dispose();
                new SignInPage();
            });

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
}