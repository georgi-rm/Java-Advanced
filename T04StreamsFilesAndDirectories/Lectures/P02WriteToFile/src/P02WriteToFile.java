import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) {
        String inputPath = "C:\\Temp\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Temp\\Java\\output.txt";
        Set<Character> punctuationToRemove = new HashSet<>();
        Collections.addAll(punctuationToRemove, ',', '.', '!', '?');

        try {
            FileInputStream inputStream = new FileInputStream(inputPath);
            FileOutputStream outputStream = new FileOutputStream(outputPath);

            int readOneByte = inputStream.read();
            while (readOneByte >= 0) {
                if (!punctuationToRemove.contains((char)readOneByte)) {
                    outputStream.write(readOneByte);
                }
                readOneByte = inputStream.read();
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
