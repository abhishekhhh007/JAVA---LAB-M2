
import java.awt.*;
import java.awt.event.*;

public class MouseKeyboardEvents extends Frame {

    Label mousePosition, message;
    Panel panel;

    MouseKeyboardEvents() {
        setTitle("Mouse and Keyboard Events");
        setSize(500, 350);
        setLayout(new BorderLayout());

        mousePosition = new Label("Mouse Position: Move the mouse");
        message = new Label("Click inside the panel or press a key");

        panel = new Panel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setFocusable(true);

        add(mousePosition, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(message, BorderLayout.SOUTH);

        
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                message.setText("Mouse clicked at: X = "
                        + e.getX() + ", Y = " + e.getY());
                panel.requestFocusInWindow();
            }
        });

        
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                mousePosition.setText("Mouse Position: X = "
                        + e.getX() + ", Y = " + e.getY());
            }
        });

      
        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                message.setText("Key Pressed: "
                        + KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
        panel.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new MouseKeyboardEvents();
    }
}
