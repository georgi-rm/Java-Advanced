import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P07ListFiles {
    public static void main(String[] args) {
        Path folderToList = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File myFile = folderToList.toFile();
        File[] listedFiles = myFile.listFiles();

        if (listedFiles != null) {
            for (File file : listedFiles) {
                if (file.isFile()) {
                    System.out.printf("%s: [%d]%n", file.getName(), file.length());
                }
            }
        }
    }
}
