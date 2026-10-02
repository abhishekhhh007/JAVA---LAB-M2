
import java.awt.*;
import java.awt.event.*;

public class StudentPerformance extends Frame implements ActionListener {

    TextField name, rollNo, mark1, mark2, mark3;
    TextField total, average, result;
    Button calculate, clear;
    Panel panel;

    StudentPerformance() {
        setTitle("Student Performance Management System");
        setSize(500, 450);
        setLayout(new BorderLayout(10, 10));

        Label heading = new Label(
            "Student Performance Management System",
            Label.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        add(heading, BorderLayout.NORTH);

        panel = new Panel(new GridLayout(8, 2, 10, 10));

        panel.add(new Label("Student Name:"));
        name = new TextField();
        panel.add(name);

        panel.add(new Label("Roll Number:"));
        rollNo = new TextField();
        panel.add(rollNo);

        panel.add(new Label("Subject 1 Marks:"));
        mark1 = new TextField();
        panel.add(mark1);

        panel.add(new Label("Subject 2 Marks:"));
        mark2 = new TextField();
        panel.add(mark2);

        panel.add(new Label("Subject 3 Marks:"));
        mark3 = new TextField();
        panel.add(mark3);

        panel.add(new Label("Total Marks:"));
        total = new TextField();
        total.setEditable(false);
        panel.add(total);

        panel.add(new Label("Average Marks:"));
        average = new TextField();
        average.setEditable(false);
        panel.add(average);

        panel.add(new Label("Result:"));
        result = new TextField();
        result.setEditable(false);
        panel.add(result);

        add(panel, BorderLayout.CENTER);

        Panel buttonPanel = new Panel(new FlowLayout());

        calculate = new Button("Calculate");
        clear = new Button("Clear");

        buttonPanel.add(calculate);
        buttonPanel.add(clear);

        add(buttonPanel, BorderLayout.SOUTH);

        calculate.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clear) {
            name.setText("");
            rollNo.setText("");
            mark1.setText("");
            mark2.setText("");
            mark3.setText("");
            total.setText("");
            average.setText("");
            result.setText("");
            return;
        }

        try {
            String studentName = name.getText().trim();
            String studentRoll = rollNo.getText().trim();

            if (studentName.isEmpty() || studentRoll.isEmpty()) {
                result.setText("Enter student details");
                return;
            }

            double m1 = Double.parseDouble(mark1.getText().trim());
            double m2 = Double.parseDouble(mark2.getText().trim());
            double m3 = Double.parseDouble(mark3.getText().trim());

            if (m1 < 0 || m1 > 100 ||
                m2 < 0 || m2 > 100 ||
                m3 < 0 || m3 > 100) {
                result.setText("Marks must be 0-100");
                return;
            }

            double sum = m1 + m2 + m3;
            double avg = sum / 3.0;

            total.setText(String.valueOf(sum));
            average.setText(String.format("%.2f", avg));

            if (m1 >= 35 && m2 >= 35 && m3 >= 35) {
                result.setText("PASS");
            } else {
                result.setText("FAIL");
            }

        } catch (NumberFormatException ex) {
            result.setText("Enter valid marks");
        }
    }

    public static void main(String[] args) {
        new StudentPerformance();
    }
}
