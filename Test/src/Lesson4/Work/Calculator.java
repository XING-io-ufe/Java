package Lesson4.Work;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator {

    private JFrame frame;
    private JButton Zero;
    private JButton One;
    private JButton Two;
    private JButton Three;
    private JButton Four;
    private JButton Five;
    private JButton Six;
    private JButton Seven;
    private JButton Eight;
    private JButton Nine;
    private JButton Dot;
    private JButton Addition;
    private JButton Subtraction;
    private JButton Multiplication;
    private JButton Division;
    private JButton Equal;
    private JTextField textField;


    public Calculator() {
        frame = new JFrame("sum example");
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        Zero = new JButton("0");
        One = new JButton("1");
        Two = new JButton("2");
        Three = new JButton("3");
        Four = new JButton("4");
        Five = new JButton("5");
        Six = new JButton("6");
        Seven = new JButton("7");
        Eight = new JButton("8");
        Nine = new JButton("9");
        Dot = new JButton(".");
        Addition = new JButton("+");
        Subtraction = new JButton("-");
        Multiplication = new JButton("*");
        Division = new JButton("/");
        Equal = new JButton("=");


        textField.setBounds(10, 10, 350, 40);
        Zero.setBounds(30,60, 75, 75);
        One.setBounds(115,60, 75, 75);
        Two.setBounds(200,60, 75, 75);
        Three.setBounds(285,60, 75, 75);
        Four.setBounds(30,145, 75, 75);
        Five.setBounds(115,145, 75, 75);
        Six.setBounds(200,145, 75, 75);
        Seven.setBounds(285,145, 75, 75);
        Eight.setBounds(30,230, 75, 75);
        Nine.setBounds(115,230, 75, 75);
        Dot.setBounds(200,230, 75, 75);
        Addition.setBounds(285,230, 75, 75);
        Subtraction.setBounds(30,315, 75, 75);
        Multiplication.setBounds(115,315, 75, 75);
        Division.setBounds(200,315, 75, 75);
        Equal.setBounds(285,315, 75, 75);



        Addition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(Zero.getText());
                int b = Integer.parseInt(One.getText());

                int total = a + b;

                Equal.setText(String.valueOf(total));
            }

        });


        frame.add(textField);
        frame.add(Zero);
        frame.add(One);
        frame.add(Two);
        frame.add(Three);
        frame.add(Four);
        frame.add(Five);
        frame.add(Six);
        frame.add(Seven);
        frame.add(Eight);
        frame.add(Nine);
        frame.add(Dot);
        frame.add(Addition);
        frame.add(Subtraction);
        frame.add(Multiplication);
        frame.add(Division);
        frame.add(Equal);
        frame.setVisible(true);


    }


    public static void main(String[] args) {
        new Calculator();
    }
}
