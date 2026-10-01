import java.applet.Applet;
import java.awt.*;

public class AppletLifeCycle extends Applet {

    public void init() {
        System.out.println("init() method is executed");
    }

    public void start() {
        System.out.println("start() method is executed");
    }

    public void paint(Graphics g) {
        g.drawString("paint() method is executed", 50, 50);
        System.out.println("paint() method is executed");
    }

    public void stop() {
        System.out.println("stop() method is executed");
    }

    public void destroy() {
        System.out.println("destroy() method is executed");
    }

    
    public static void main(String[] args) {

        AppletLifeCycle applet = new AppletLifeCycle();

        Frame frame = new Frame("Applet Life Cycle");

        frame.setSize(500, 300);
        frame.add(applet);

        
        applet.init();
        applet.start();

        frame.setVisible(true);

        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                applet.stop();
                applet.destroy();
                frame.dispose();
            }
        });
    }
}
