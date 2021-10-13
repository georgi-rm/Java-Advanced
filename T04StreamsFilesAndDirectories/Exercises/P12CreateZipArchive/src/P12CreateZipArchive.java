import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) throws IOException {
        Path firstFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path secondFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        Path thirdFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        Path outputFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\Output\\files.zip");

        FileOutputStream outputStream = new FileOutputStream(outputFilePath.toFile());
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

        addFileToZip(firstFilePath, zipOutputStream);
        addFileToZip(secondFilePath, zipOutputStream);
        addFileToZip(thirdFilePath, zipOutputStream);

        zipOutputStream.close();

    }

    private static void addFileToZip(Path inputFilePath, ZipOutputStream zipOutputStream) throws IOException {
        FileInputStream inputStream = new FileInputStream(inputFilePath.toFile());

        byte[] buffer = inputStream.readAllBytes();
        ZipEntry newZipEntry = new ZipEntry(inputFilePath.getFileName().toString());
        zipOutputStream.putNextEntry(newZipEntry);
        zipOutputStream.write(buffer);
        zipOutputStream.closeEntry();
        inputStream.close();
    }

}
