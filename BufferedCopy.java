import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) {

        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        try {
            BufferedInputStream bis =
                    new BufferedInputStream(new FileInputStream(sourceFile));

            BufferedOutputStream bos =
                    new BufferedOutputStream(new FileOutputStream(destinationFile));

            int data;

            // Read from input.txt and write to output.txt
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

            bis.close();
            bos.close();

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}