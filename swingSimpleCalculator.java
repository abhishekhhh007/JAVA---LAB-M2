
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class swingSimpleCalculator extends JFrame implements ActionListener {

    JLabel label1, label2, resultLabel;
    JTextField num1Field, num2Field, resultField;
    JButton addButton, subButton, mulButton, divButton, clearButton, exitButton;

    swingSimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        label1 = new JLabel("Enter First Number:");
        num1Field = new JTextField();

        label2 = new JLabel("Enter Second Number:");
        num2Field = new JTextField();

        resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("Addition (+)");
        subButton = new JButton("Subtraction (-)");
        mulButton = new JButton("Multiplication (*)");
        divButton = new JButton("Division (/)");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        add(label1);
        add(num1Field);

        add(label2);
        add(num2Field);

        add(resultLabel);
        add(resultField);

        add(addButton);
        add(subButton);

        add(mulButton);
        add(divButton);

        add(clearButton);
        add(exitButton);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearButton) {
            num1Field.setText("");
            num2Field.setText("");
            resultField.setText("");
            return;
        }

        if (e.getSource() == exitButton) {
            System.exit(0);
        }

        try {
            double num1 = Double.parseDouble(num1Field.getText().trim());
            double num2 = Double.parseDouble(num2Field.getText().trim());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            }
            else if (e.getSource() == subButton) {
                result = num1 - num2;
            }
            else if (e.getSource() == mulButton) {
                result = num1 * num2;
            }
            else if (e.getSource() == divButton) {

                if (num2 == 0) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Cannot divide by zero!",
                        "Math Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    resultField.setText("");
                    return;
                }

                result = num1 / num2;
            }

            resultField.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numbers!",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
            resultField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}

