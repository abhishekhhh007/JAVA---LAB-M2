 import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        try {
            // true means append mode
            FileOutputStream fos = new FileOutputStream("output.txt", true);

            fos.write(text.getBytes());
            fos.write(System.lineSeparator().getBytes());

            fos.close();

            System.out.println("Data written successfully to output.txt");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        sc.close();
    }
} 
    

