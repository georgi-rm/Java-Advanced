import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        String path = System.getProperty("user.home") + "\\JavaLearning\\Output\\outputP09SerializeCustomObject.txt";
        Cube myCube = new Cube();

        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(path));
            outStream.writeObject(myCube);
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
