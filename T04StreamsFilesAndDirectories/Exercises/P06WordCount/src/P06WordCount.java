import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class P06WordCount {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> occurrences = new HashMap<>();

        Map<String, Integer> wordsFromSecondFile = new HashMap<>();

        Path firstPath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path secondPath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        FileInputStream inputStreamOfFirstFile = new FileInputStream(firstPath.toString());
        FileInputStream inputStreamOfSecondFile = new FileInputStream(secondPath.toString());

        Scanner scannerForSecondFile = new Scanner(inputStreamOfSecondFile);

        while (scannerForSecondFile.hasNext()) {
            String nextWord = scannerForSecondFile.next();
            wordsFromSecondFile.putIfAbsent(nextWord, 0);
            int count = wordsFromSecondFile.get(nextWord);
            count++;
            wordsFromSecondFile.put(nextWord, count);
        }
        Scanner scannerForFirstFile = new Scanner(inputStreamOfFirstFile);

        while (scannerForFirstFile.hasNext()) {
            String nextWord = scannerForFirstFile.next();
            if (wordsFromSecondFile.containsKey(nextWord)) {
                occurrences.putIfAbsent(nextWord, 0);
                int count = occurrences.get(nextWord);
                count += wordsFromSecondFile.get(nextWord);
                occurrences.put(nextWord, count);
            }
        }

        PrintWriter printWriter = new PrintWriter(System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP06WordCount.txt");
        occurrences.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> printWriter.printf("%s - %d%n", e.getKey(), e.getValue()));
        printWriter.close();
    }
}
