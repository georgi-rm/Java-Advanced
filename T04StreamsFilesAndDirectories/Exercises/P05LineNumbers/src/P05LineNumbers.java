import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        PrintWriter printWriter = new PrintWriter(System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP05LineNumbers.txt");

        int lineNumber = 1;
        String lineData = bufferedReader.readLine();
        while (lineData != null) {
            printWriter.printf("%d. %s%n", lineNumber, lineData);
            lineNumber++;
            lineData = bufferedReader.readLine();
        }
        bufferedReader.close();
        printWriter.close();
    }
}
