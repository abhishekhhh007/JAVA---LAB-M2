import java.io.*;
import java.util.Scanner;

public class EmployeeRecord {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String fileName = "employees.dat";

        try {
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream(fileName)
            );

            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++) {

                System.out.println("\nEnter details of Employee " + i);

                System.out.print("Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Employee Name: ");
                String name = sc.nextLine();

                System.out.print("Salary: ");
                double salary = sc.nextDouble();

                dos.writeInt(id);
                dos.writeUTF(name);
                dos.writeDouble(salary);
            }

            dos.close();

            System.out.println("\nEmployee details stored successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing: " + e.getMessage());
        }

        try {
            DataInputStream dis = new DataInputStream(
                    new FileInputStream(fileName)
            );

            System.out.println("\n--- Employee Details ---");

            while (true) {
                try {
                    int id = dis.readInt();
                    String name = dis.readUTF();
                    double salary = dis.readDouble();

                    System.out.println("Employee ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Salary: " + salary);

                } catch (EOFException e) {
                    break;
                }
            }

            dis.close();

        } catch (IOException e) {
            System.out.println("Error while reading: " + e.getMessage());
        }

        sc.close();
    }
}