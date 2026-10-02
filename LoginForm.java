
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {

    JLabel userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginButton, resetButton, exitButton;

    final String USERNAME = "admin";
    final String PASSWORD = "1234";

    LoginForm() {
        setTitle("Login Form");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");

        userField = new JTextField();
        passField = new JPasswordField();

        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");

        add(userLabel);
        add(userField);

        add(passLabel);
        add(passField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(exitButton);

        add(new JLabel("Actions:"));
        add(buttonPanel);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {

            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals(USERNAME) &&
                password.equals(PASSWORD)) {

                JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );

            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password!",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }

        else if (e.getSource() == resetButton) {
            userField.setText("");
            passField.setText("");
            userField.requestFocus();

        }

        else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}
