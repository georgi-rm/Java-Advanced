import java.io.*;
import java.util.Properties;

public class P01SumLines {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                int sumOfCharacters = 0;
                for (int i = 0; i < line.length(); i++) {
                    sumOfCharacters += line.charAt(i);
                }
                System.out.println(sumOfCharacters);
                line = bufferedReader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
