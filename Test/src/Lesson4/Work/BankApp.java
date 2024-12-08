package Lesson4.Work;

import javax.swing.*;
import java.awt.event.*;

public class BankApp {
    private static double balance = 1000.0; // Дансны анхны үлдэгдэл

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank Application");
        JLabel balanceLabel = new JLabel("Account Balance: $" + balance);
        JTextField depositField = new JTextField();
        JTextField withdrawField = new JTextField();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        // Layout
        frame.setLayout(null);
        balanceLabel.setBounds(100, 20, 200, 30);
        depositField.setBounds(100, 60, 200, 30);
        depositButton.setBounds(100, 100, 100, 30);
        withdrawField.setBounds(100, 140, 200, 30);
        withdrawButton.setBounds(100, 180, 100, 30);

        frame.add(balanceLabel);
        frame.add(depositField);
        frame.add(depositButton);
        frame.add(withdrawField);
        frame.add(withdrawButton);

        // Deposit Button Action
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = depositField.getText();
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount > 0) {
                        balance += amount; // Дансны үлдэгдэлд нэмэх
                        balanceLabel.setText("Account Balance: $" + balance);
                        depositField.setText(""); // Текст талбарыг цэвэрлэх
                    } else {
                        balanceLabel.setText("Please enter a positive amount.");
                    }
                } catch (NumberFormatException ex) {
                    balanceLabel.setText("Invalid amount. Please enter a number.");
                }
            }
        });

        // Withdraw Button Action
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = withdrawField.getText();
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount > 0 && amount <= balance) {
                        balance -= amount; // Дансны үлдэгдэлээс хасах
                        balanceLabel.setText("Account Balance: $" + balance);
                        withdrawField.setText(""); // Текст талбарыг цэвэрлэх
                    } else if (amount > balance) {
                        balanceLabel.setText("Insufficient funds.");
                    } else {
                        balanceLabel.setText("Please enter a positive amount.");
                    }
                } catch (NumberFormatException ex) {
                    balanceLabel.setText("Invalid amount. Please enter a number.");
                }
            }
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}