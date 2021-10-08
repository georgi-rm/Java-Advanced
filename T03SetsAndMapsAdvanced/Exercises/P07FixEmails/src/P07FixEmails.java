import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsOfPeople = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")) {

            String email = scanner.nextLine();
            String emailLowerCase = email.toLowerCase();
            if (!emailLowerCase.endsWith("us") && !emailLowerCase.endsWith("uk") && !emailLowerCase.endsWith("com")) {
                emailsOfPeople.put(email, name);
            }

            name = scanner.nextLine();
        }

        emailsOfPeople.forEach((key, value) -> System.out.printf("%s -> %s%n", value, key));
    }
}
