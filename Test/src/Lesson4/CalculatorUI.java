package Lesson4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI {

    private JFrame frame;
    private JTextField FirstNumberTF;
    private JTextField SecondNumberTF;
    private JButton calcBtn;
    private JLabel resultLabel;
    private JLabel totalLabel;


    public CalculatorUI(){
        frame = new JFrame("sum example");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FirstNumberTF = new JTextField();
        SecondNumberTF = new JTextField();
        calcBtn = new JButton("Sum number");
        resultLabel = new JLabel("Result: ");
        totalLabel = new JLabel();

        FirstNumberTF.setBounds(50,50,150,25);
        SecondNumberTF.setBounds(50,100,150,25);
        calcBtn.setBounds(75,150,120,30);
        resultLabel.setBounds(70,200,80,30);
        totalLabel.setBounds(160,200,80,30);

        calcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(FirstNumberTF.getText());
                int b = Integer.parseInt(SecondNumberTF.getText());

                int total = a + b;

                totalLabel.setText(String.valueOf(total));
            }

        });

        frame.add(FirstNumberTF);
        frame.add(SecondNumberTF);
        frame.add(calcBtn);
        frame.add(resultLabel);
        frame.add(totalLabel);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new CalculatorUI();

    }
}
