import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class CircleAnimation extends Applet implements Runnable {

    int x = 0;
    Thread t;
    boolean running = false;

    public void init() {
        x = 0;
    }

    public synchronized void start() {
        if (t == null) {
            running = true;
            t = new Thread(this);
            t.start();
        }
    }

    public synchronized void stop() {
        running = false;
        t = null;
    }

    public void run() {
        Thread current = Thread.currentThread();

        while (t == current && running) {
            x = x + 10;

            if (x > getWidth()) {
                x = 0;
            }

            repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public void paint(Graphics g) {
        g.drawString("Simple Circle Animation", 20, 20);
        g.fillOval(x, 80, 50, 50);
    }

    public static void main(String[] args) {
        Frame f = new Frame("Circle Animation");
        CircleAnimation applet = new CircleAnimation();

        applet.init();

        f.add(applet);
        f.setSize(500, 300);
        f.setVisible(true);

        applet.start();

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                applet.stop();
                f.dispose();
            }
        });
    }
}
