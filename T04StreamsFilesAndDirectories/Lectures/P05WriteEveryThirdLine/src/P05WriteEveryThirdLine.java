import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP05WriteEveryThirdLine.txt";

        try {
            FileInputStream inputStream = new FileInputStream(inputPath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader reader = new BufferedReader(inputStreamReader);

            PrintWriter printWriter = new PrintWriter(outputPath);

            String line = reader.readLine();

            int count = 1;

            while (line != null) {
                if (count % 3 == 0) {
                    printWriter.println(line);
                }
                count++;
                line = reader.readLine();
            }
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
