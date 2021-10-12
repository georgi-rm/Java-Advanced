import java.io.*;
import java.util.Set;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(System.getProperty("user.home") + "\\JavaLearning\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        int counterVowels = 0;
        int counterConsonants = 0;
        int counterPunctuation = 0;

        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuationSet = Set.of( '!', ',', '.', '?');
        String line = bufferedReader.readLine();
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                if (vowelsSet.contains(currentSymbol)) {
                    counterVowels++;
                } else if (punctuationSet.contains(currentSymbol)) {
                    counterPunctuation++;
                } else if (currentSymbol != ' ') {
                    counterConsonants++;
                }
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

        PrintWriter printWriter = new PrintWriter(System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP04CountCharacterTypes.txt");
        printWriter.printf("Vowels: %d%n", counterVowels);
        printWriter.printf("Consonants: %d%n", counterConsonants);
        printWriter.printf("Punctuation: %d%n", counterPunctuation);
        printWriter.close();
    }
}
