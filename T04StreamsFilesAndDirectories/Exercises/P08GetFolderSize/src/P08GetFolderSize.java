import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;

public class P08GetFolderSize {
    public static void main(String[] args) {
        Path rootPath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        ArrayDeque<File> queueOfFiles = new ArrayDeque<>();
        File currentFile = rootPath.toFile();
        queueOfFiles.offer(currentFile);

        long directorySize = 0;

        while (!queueOfFiles.isEmpty()) {
            currentFile = queueOfFiles.poll();

            File[] listedFiles = currentFile.listFiles();
            if (listedFiles != null) {
                for (File listedFile : listedFiles) {
                    if (listedFile.isDirectory()) {
                        queueOfFiles.offer(listedFile);
                    } else {
                        directorySize += listedFile.length();
                    }
                }
            }
        }
        System.out.printf("Folder size: %d", directorySize);
    }
    }
