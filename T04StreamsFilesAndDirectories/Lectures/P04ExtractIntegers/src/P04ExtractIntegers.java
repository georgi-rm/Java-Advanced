import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP04ExtractIntegers.txt";

        try {
            FileInputStream inputStream = new FileInputStream(inputPath);
            Scanner scanner = new Scanner(inputStream);

            FileOutputStream outputStream = new FileOutputStream(outputPath);
            PrintStream out = new PrintStream(outputStream);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    out.println(number);
                } else {
                    scanner.next();
                }
            }
            outputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
