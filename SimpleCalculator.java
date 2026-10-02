
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {

    TextField num1, num2, result;
    Button add, sub, mul, div;

    SimpleCalculator() {
        setTitle("Simple AWT Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        Label l1 = new Label("First Number:");
        Label l2 = new Label("Second Number:");
        Label l3 = new Label("Result:");

        num1 = new TextField();
        num2 = new TextField();
        result = new TextField();
        result.setEditable(false);

        add = new Button("Addition");
        sub = new Button("Subtraction");
        mul = new Button("Multiplication");
        div = new Button("Division");

        add(l1);
        add(num1);
        add(l2);
        add(num2);
        add(l3);
        add(result);
        add(add);
        add(sub);
        add(mul);
        add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            double res = 0;

            if (e.getSource() == add) {
                res = a + b;
            } else if (e.getSource() == sub) {
                res = a - b;
            } else if (e.getSource() == mul) {
                res = a * b;
            } else if (e.getSource() == div) {
                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                res = a / b;
            }

            result.setText(String.valueOf(res));

        } catch (NumberFormatException ex) {
            result.setText("Enter valid numbers");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
