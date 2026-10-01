import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends Frame implements ActionListener {

    TextField nameField, regNoField, emailField;
    Choice courseChoice, semesterChoice;
    Checkbox male, female;
    Button submitButton, clearButton;
    TextArea output;

    StudentRegistration() {

        
        setTitle("Student Registration Form");
        setSize(500, 500);
        setLayout(new BorderLayout(10, 10));

        
        Label title = new Label("STUDENT REGISTRATION FORM", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        
        Panel formPanel = new Panel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));

        
        formPanel.add(new Label("Student Name:"));
        nameField = new TextField();
        formPanel.add(nameField);

        
        formPanel.add(new Label("Register Number:"));
        regNoField = new TextField();
        formPanel.add(regNoField);

        
        formPanel.add(new Label("Email:"));
        emailField = new TextField();
        formPanel.add(emailField);

        
        formPanel.add(new Label("Course:"));
        courseChoice = new Choice();
        courseChoice.add("BCA");
        courseChoice.add("BSc Computer Science");
        courseChoice.add("BTech");
        courseChoice.add("MCA");
        formPanel.add(courseChoice);

        
        formPanel.add(new Label("Semester:"));
        semesterChoice = new Choice();
        semesterChoice.add("Semester 1");
        semesterChoice.add("Semester 2");
        semesterChoice.add("Semester 3");
        semesterChoice.add("Semester 4");
        semesterChoice.add("Semester 5");
        semesterChoice.add("Semester 6");
        formPanel.add(semesterChoice);

        
        formPanel.add(new Label("Gender:"));

        Panel genderPanel = new Panel();
        genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        male = new Checkbox("Male");
        female = new Checkbox("Female");

        genderPanel.add(male);
        genderPanel.add(female);

        formPanel.add(genderPanel);

        add(formPanel, BorderLayout.CENTER);

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());

        submitButton = new Button("Submit");
        clearButton = new Button("Clear");

        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);


        output = new TextArea(6, 40);
        output.setEditable(false);

        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new BorderLayout());

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(output, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            String name = nameField.getText();
            String regNo = regNoField.getText();
            String email = emailField.getText();
            String course = courseChoice.getSelectedItem();
            String semester = semesterChoice.getSelectedItem();

            String gender = "";

            if (male.getState()) {
                gender = "Male";
            } else if (female.getState()) {
                gender = "Female";
            } else {
                gender = "Not Selected";
            }

            output.setText(
                "----- Student Details -----\n" +
                "Name          : " + name + "\n" +
                "Register No.  : " + regNo + "\n" +
                "Email         : " + email + "\n" +
                "Course        : " + course + "\n" +
                "Semester      : " + semester + "\n" +
                "Gender        : " + gender
            );
        }

        else if (e.getSource() == clearButton) {

            nameField.setText("");
            regNoField.setText("");
            emailField.setText("");

            courseChoice.select(0);
            semesterChoice.select(0);

            male.setState(false);
            female.setState(false);

            output.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
