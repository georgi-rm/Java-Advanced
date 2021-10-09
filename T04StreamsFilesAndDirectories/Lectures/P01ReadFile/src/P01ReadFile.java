import java.io.FileInputStream;
import java.io.IOException;

public class P01ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Temp\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileStream = new FileInputStream(path);
            int readOneByte = fileStream.read();
            while (readOneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(readOneByte));
                readOneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
