import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Path outputFilePath = Paths.get(System.getProperty("user.home") + "\\JavaLearning\\Output\\course.ser");

        Course myCourse = new Course("SoftUni", 356);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream( new FileOutputStream(outputFilePath.toFile()));
        objectOutputStream.writeObject(myCourse);
        objectOutputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream(outputFilePath.toFile()));
        Course newCourse = (Course) inputStream.readObject();
        System.out.println(newCourse);
    }
}
