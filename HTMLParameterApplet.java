
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class HTMLParameterApplet extends Applet {

    String message;
    Color bgColor, fgColor;

    public void init() {
        message = getParameter("message");
        String bg = getParameter("bgcolor");
        String fg = getParameter("fgcolor");

        bgColor = getColor(bg, Color.WHITE);
        fgColor = getColor(fg, Color.BLACK);

        setBackground(bgColor);
        setForeground(fgColor);
    }

    Color getColor(String color, Color defaultColor) {
        if (color == null)
            return defaultColor;

        switch (color.toLowerCase()) {
            case "red": return Color.RED;
            case "green": return Color.GREEN;
            case "blue": return Color.BLUE;
            case "yellow": return Color.YELLOW;
            case "black": return Color.BLACK;
            case "white": return Color.WHITE;
            case "cyan": return Color.CYAN;
            case "pink": return Color.PINK;
            default: return defaultColor;
        }
    }

    public void paint(Graphics g) {
        g.setColor(fgColor);
        g.drawString(message, 50, 100);
    }

    public static void main(String[] args) {
        Frame f = new Frame("HTML Parameter Applet");
        HTMLParameterApplet applet = new HTMLParameterApplet();

        
        applet.message = "Welcome to Java Applet!";
        applet.bgColor = Color.YELLOW;
        applet.fgColor = Color.BLUE;

        applet.setBackground(applet.bgColor);
        applet.setForeground(applet.fgColor);

        f.add(applet);
        f.setSize(500, 250);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
}
