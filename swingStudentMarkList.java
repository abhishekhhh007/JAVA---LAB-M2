
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class swingStudentMarkList extends JFrame implements ActionListener {

    JLabel nameLabel, regLabel, m1Label, m2Label, m3Label;
    JTextField nameField, regField, m1Field, m2Field, m3Field;
    JTextArea resultArea;
    JButton calculateButton, clearButton, exitButton;

    swingStudentMarkList() {
        setTitle("Student Mark List Application");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        nameLabel = new JLabel("Student Name:");
        nameField = new JTextField();

        regLabel = new JLabel("Register Number:");
        regField = new JTextField();

        m1Label = new JLabel("Subject 1 Marks:");
        m1Field = new JTextField();

        m2Label = new JLabel("Subject 2 Marks:");
        m2Field = new JTextField();

        m3Label = new JLabel("Subject 3 Marks:");
        m3Field = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        inputPanel.add(regLabel);
        inputPanel.add(regField);

        inputPanel.add(m1Label);
        inputPanel.add(m1Field);

        inputPanel.add(m2Label);
        inputPanel.add(m2Field);

        inputPanel.add(m3Label);
        inputPanel.add(m3Field);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea(8, 30);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculateButton) {
            try {
                String name = nameField.getText().trim();
                String regNo = regField.getText().trim();

                if (name.isEmpty() || regNo.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Please enter the student name and register number."
                    );
                    return;
                }

                int m1 = Integer.parseInt(m1Field.getText().trim());
                int m2 = Integer.parseInt(m2Field.getText().trim());
                int m3 = Integer.parseInt(m3Field.getText().trim());

                if (m1 < 0 || m1 > 100 ||
                    m2 < 0 || m2 > 100 ||
                    m3 < 0 || m3 > 100) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Marks must be between 0 and 100.",
                        "Invalid Marks",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                int total = m1 + m2 + m3;
                double average = total / 3.0;
                String grade;

                if (average >= 90)
                    grade = "A+";
                else if (average >= 80)
                    grade = "A";
                else if (average >= 70)
                    grade = "B";
                else if (average >= 60)
                    grade = "C";
                else if (average >= 50)
                    grade = "D";
                else
                    grade = "F";

                resultArea.setText(
                    "       STUDENT MARK LIST\n" +
                    "--------------------------------\n" +
                    "Name: " + name + "\n" +
                    "Register Number: " + regNo + "\n" +
                    "Subject 1 Marks: " + m1 + "\n" +
                    "Subject 2 Marks: " + m2 + "\n" +
                    "Subject 3 Marks: " + m3 + "\n" +
                    "Total: " + total + " / 300\n" +
                    String.format("Average: %.2f%n", average) +
                    "Grade: " + grade
                );

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid integer marks in all subjects.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }

        else if (e.getSource() == clearButton) {
            nameField.setText("");
            regField.setText("");
            m1Field.setText("");
            m2Field.setText("");
            m3Field.setText("");
            resultArea.setText("");
        }

        else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentMarkList());
    }
}

