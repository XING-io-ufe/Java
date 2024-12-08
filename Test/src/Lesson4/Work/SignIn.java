package Lesson4.Work;

import javax.swing.*;
import java.awt.event.*;

public class SignIn {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Нэвтрэх хуудас");
        frame.setLayout(null);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JTextField uName = new JTextField("example@gmail.com");
        JPasswordField pName = new JPasswordField("23456");
        JLabel userEmail = new JLabel("мейл");
        JLabel userPass = new JLabel("Нууц үг");
        JButton logBtn = new JButton("нэвтрэх");

        userEmail.setBounds(25, 35, 100, 50);
        uName.setBounds(100, 50, 200, 30);
        userPass.setBounds(20, 85, 100, 50);
        pName.setBounds(100, 100, 200, 30);
        logBtn.setBounds(100, 150, 100, 30);


        frame.add(userEmail);
        frame.add(uName);
        frame.add(userPass);
        frame.add(pName);
        frame.add(logBtn);
        frame.setVisible(true);


        logBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mail = "example@gmail.com";
                String pwd = "23456";

                String user = uName.getText();
                String pass = pName.getText();

                if(user.equals(mail) && pass.equals(pwd)) {
                    System.out.println("ta login hiilee");
                } else{
                    System.out.println("Nuuts ug buruu bn");
                }
            }
        });
    }
}