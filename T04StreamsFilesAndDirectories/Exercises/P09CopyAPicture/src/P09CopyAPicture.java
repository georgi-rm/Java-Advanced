import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P09CopyAPicture {
    public static void main(String[] args) throws IOException {
        Path inputFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\MyResources\\IMG_00061.jpg");
        Path outputFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\Output\\picture-copy.jpg");

        FileInputStream inputStream = new FileInputStream(inputFilePath.toFile());

        byte[] buffer = inputStream.readAllBytes();
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(outputFilePath.toFile());
        outputStream.write(buffer);
        outputStream.close();
    }
}
