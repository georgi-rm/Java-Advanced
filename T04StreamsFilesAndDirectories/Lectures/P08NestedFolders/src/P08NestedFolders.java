import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) {
        Path rootPath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        ArrayDeque<File> queueOfFiles = new ArrayDeque<>();
        File currentFile = rootPath.toFile();
        queueOfFiles.offer(currentFile);

        int countOfDirectories = 0;

        while (!queueOfFiles.isEmpty()) {
            currentFile = queueOfFiles.poll();
            countOfDirectories++;
            System.out.println(currentFile.getName());
            File[] listedFiles = currentFile.listFiles();
            if (listedFiles != null) {
                for (File listedFile : listedFiles) {
                    if (listedFile.isDirectory()) {
                        queueOfFiles.offer(listedFile);
                    }
                }
            }
        }
        System.out.printf("%d folders", countOfDirectories);
    }

}
