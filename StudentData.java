import java.io.*;

public class StudentData {
    public static void main(String[] args) {

        String fileName = "student.dat";

        
        int rollNo = 15;
        String name = "Abhishek";
        double marks = 85.5;

        
        try {
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream(fileName)
            );

            dos.writeInt(rollNo);
            dos.writeUTF(name);
            dos.writeDouble(marks);

            dos.close();

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing: " + e.getMessage());
        }

        
        try {
            DataInputStream dis = new DataInputStream(
                    new FileInputStream(fileName)
            );

            int r = dis.readInt();
            String n = dis.readUTF();
            double m = dis.readDouble();

            dis.close();

            System.out.println("\nStudent Details");
            System.out.println("Roll Number: " + r);
            System.out.println("Name: " + n);
            System.out.println("Marks: " + m);

        } catch (IOException e) {
            System.out.println("Error while reading: " + e.getMessage());
        }
    }
}