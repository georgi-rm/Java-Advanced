import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path firstFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path secondFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        Path outputFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP07MergeTwoFiles.txt");

        FileWriter fileWriter = new FileWriter(outputFilePath.toFile());
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        appendContentOfFile(firstFilePath, bufferedWriter);
        appendContentOfFile(secondFilePath, bufferedWriter);
        bufferedWriter.close();
    }

    private static void appendContentOfFile(Path inputFilePath, BufferedWriter bufferedWriter) throws IOException {
        FileReader fileReader = new FileReader(inputFilePath.toFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int readByte = bufferedReader.read();
        while (readByte > 0) {
            bufferedWriter.write(readByte);
            readByte = bufferedReader.read();
        }
        bufferedWriter.write('\n');
        bufferedReader.close();
    }

}
