import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MouseEventApplet extends Applet implements MouseListener {

    int x = 0, y = 0;
    boolean clicked = false;

    public void init() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        if (clicked) {
            g.drawString("Mouse clicked at:", 50, 50);
            g.drawString("X Coordinate: " + x, 50, 80);
            g.drawString("Y Coordinate: " + y, 50, 110);
        } else {
            g.drawString("Move the mouse inside the applet", 50, 50);
        }
    }

    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        clicked = true;
        repaint();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        Frame f = new Frame("Mouse Event Applet");
        MouseEventApplet applet = new MouseEventApplet();

        applet.init();

        f.add(applet);
        f.setSize(500, 300);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
}
