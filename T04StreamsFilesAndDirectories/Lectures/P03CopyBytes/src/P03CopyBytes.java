import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\Temp\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Temp\\Java\\outputP03CopyBytes.txt";

        try {
            FileInputStream inputStream = new FileInputStream(inputPath);
            FileOutputStream outputStream = new FileOutputStream(outputPath);

            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                if (oneByte == ' ' || oneByte == '\n') {
                    outputStream.write(oneByte);
                } else {
                    String digit = String.valueOf(oneByte);
                    for (int i = 0; i < digit.length(); i++) {
                        outputStream.write(digit.charAt(i));
                    }
                }
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
