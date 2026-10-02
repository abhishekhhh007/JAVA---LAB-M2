
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentMarkList extends JFrame implements ActionListener {

    JTextField nameField, regField, mark1Field, mark2Field, mark3Field;
    JTextArea resultArea;
    JButton calculateButton, clearButton, exitButton;

    StudentMarkList() {
        setTitle("Student Mark List");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));

        panel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Register Number:"));
        regField = new JTextField();
        panel.add(regField);

        panel.add(new JLabel("Subject 1 Marks:"));
        mark1Field = new JTextField();
        panel.add(mark1Field);

        panel.add(new JLabel("Subject 2 Marks:"));
        mark2Field = new JTextField();
        panel.add(mark2Field);

        panel.add(new JLabel("Subject 3 Marks:"));
        mark3Field = new JTextField();
        panel.add(mark3Field);

        add(panel, BorderLayout.NORTH);

        resultArea = new JTextArea(8, 30);
        resultArea.setEditable(false);
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
                        this, "Enter student name and register number.");
                    return;
                }

                int m1 = Integer.parseInt(mark1Field.getText().trim());
                int m2 = Integer.parseInt(mark2Field.getText().trim());
                int m3 = Integer.parseInt(mark3Field.getText().trim());

                if (m1 < 0 || m1 > 100 ||
                    m2 < 0 || m2 > 100 ||
                    m3 < 0 || m3 > 100) {

                    JOptionPane.showMessageDialog(
                        this, "Marks must be between 0 and 100.");
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
                    "STUDENT MARK LIST\n" +
                    "--------------------------\n" +
                    "Name: " + name + "\n" +
                    "Register Number: " + regNo + "\n" +
                    "Subject 1: " + m1 + "\n" +
                    "Subject 2: " + m2 + "\n" +
                    "Subject 3: " + m3 + "\n" +
                    "Total: " + total + " / 300\n" +
                    String.format("Average: %.2f%n", average) +
                    "Grade: " + grade
                );

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this, "Please enter valid integer marks.");
            }
        }

        else if (e.getSource() == clearButton) {
            nameField.setText("");
            regField.setText("");
            mark1Field.setText("");
            mark2Field.setText("");
            mark3Field.setText("");
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
