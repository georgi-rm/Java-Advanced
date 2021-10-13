import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P10SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Path outputFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP10SerializeArrayList.txt");

        List<Double> myDoubleList = new ArrayList<>();
        myDoubleList.add(1.2);
        myDoubleList.add(3.4);
        myDoubleList.add(5.67);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream( new FileOutputStream(outputFilePath.toFile()));
        objectOutputStream.writeObject(myDoubleList);
        objectOutputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream(outputFilePath.toFile()));
        List<Double> newDoubleList = (List<Double>) inputStream.readObject();
        System.out.println(newDoubleList);
    }
}
