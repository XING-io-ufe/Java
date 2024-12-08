package Lesson4.Work;

import javax.swing.*;
import java.awt.event.*;

public class SignUp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Бүртгүүлэх хуудас");
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
        JButton rBtn = new JButton("бүртгүүлэх");


        last.setBounds(10, 10, 100, 30);
        lastName.setBounds(10, 40, 200, 30);

        first.setBounds(10,70,100,30);
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
                System.out.println("User  registered");
            }
        });
    }
}