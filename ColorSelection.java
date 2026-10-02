
import java.awt.*;
import java.awt.event.*;

public class ColorSelection extends Frame implements ActionListener {

    Panel panel;
    Button red, green, blue, yellow, reset;

    ColorSelection() {
        setTitle("Color Selection Application");
        setSize(500, 300);
        setLayout(new BorderLayout());

        panel = new Panel();
        panel.setBackground(Color.WHITE);

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());

        red = new Button("Red");
        green = new Button("Green");
        blue = new Button("Blue");
        yellow = new Button("Yellow");
        reset = new Button("Reset");

        buttonPanel.add(red);
        buttonPanel.add(green);
        buttonPanel.add(blue);
        buttonPanel.add(yellow);
        buttonPanel.add(reset);

        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        yellow.addActionListener(this);
        reset.addActionListener(this);

        add(buttonPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == red) {
            panel.setBackground(Color.RED);
        } else if (e.getSource() == green) {
            panel.setBackground(Color.GREEN);
        } else if (e.getSource() == blue) {
            panel.setBackground(Color.BLUE);
        } else if (e.getSource() == yellow) {
            panel.setBackground(Color.YELLOW);
        } else if (e.getSource() == reset) {
            panel.setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        new ColorSelection();
    }
}
