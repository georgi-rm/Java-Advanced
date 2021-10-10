import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class P03AllCapitals {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            PrintWriter printWriter = new PrintWriter(System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP03AllCapitals.txt");

            String line = bufferedReader.readLine();
            while (line != null) {
                line = line.toUpperCase();
                printWriter.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
