package Lesson4.Work;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Нүүр хуудас");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel balance = new JLabel("Үлдэгдэл: 50000төг");
        JButton depobtn = new JButton("Орлого");
        JButton withbtn = new JButton("Зарлага");

        balance.setBounds(100, 50, 200, 30);
        depobtn.setBounds(100, 100, 100, 30);
        withbtn.setBounds(210, 100, 100, 30);

        frame.add(balance);
        frame.add(depobtn);
        frame.add(withbtn);


        depobtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Deposit clicked");
            }
        });


        withbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Withdraw clicked");
            }
        });

        frame.setVisible(true);
    }
}