import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class StudentInfoApplet extends Applet {

    String name, regno, course, semester;

    public void init() {
        name = getParameter("name");
        regno = getParameter("regno");
        course = getParameter("course");
        semester = getParameter("semester");
    }

    public void paint(Graphics g) {
        g.drawString("STUDENT INFORMATION", 150, 50);
        g.drawString("Name: " + name, 100, 100);
        g.drawString("Register Number: " + regno, 100, 130);
        g.drawString("Course: " + course, 100, 160);
        g.drawString("Semester: " + semester, 100, 190);
    }

    public static void main(String[] args) {
        Frame f = new Frame("Student Information");
        StudentInfoApplet applet = new StudentInfoApplet();

        applet.name = "Abhishek";
        applet.regno = "101";
        applet.course = "BCA";
        applet.semester = "3";

        f.add(applet);
        f.setSize(500, 300);
        f.setVisible(true);

        applet.repaint();

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
}
