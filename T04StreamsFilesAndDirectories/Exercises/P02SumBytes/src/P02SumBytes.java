import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Long sumOfCharacters = 0L;
            String line = bufferedReader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    sumOfCharacters += line.charAt(i);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            System.out.println(sumOfCharacters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
