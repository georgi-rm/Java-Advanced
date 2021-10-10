import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) {
        String inputPathString = System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPathString = System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP06SortLines.txt";

        Path inputPath = Paths.get(inputPathString);
        try {
            List<String> allLines = Files.readAllLines(inputPath);
            Collections.sort(allLines);

            Files.write(Paths.get(outputPathString), allLines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
