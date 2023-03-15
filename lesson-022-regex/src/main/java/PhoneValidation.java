import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.regex.Pattern;

public class PhoneValidation {
    // +7-123-456-78-90
    // +7 123 456 78 90
    private static final Pattern pattern = Pattern.compile("\\+(\\d{1,3})[- ](\\d{3})[- ]\\d{3}[- ]\\d{2}[- ]\\d{2}");

    // игнорируем throws IOException
    public static void main(String[] args) throws IOException {
        var consoleReader = createConsoleReader();
        System.out.println("Input phone number:");
        String input = consoleReader.readLine();

        var matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("Phone number is correct");
            System.out.println("Country code: " + matcher.group(1));
//            System.out.println("Country code: " + matcher.group("country-name"));
            System.out.println("Mobile operator code: " + matcher.group(2));
            // some logic here
        } else {
            System.out.println("Phone number is incorrect. Please follow the format: +7-123-456-78-90");
        }
    }

    // игнорируем страшную конструкцию
    private static LineNumberReader createConsoleReader() {
        return new LineNumberReader(new InputStreamReader(System.in));
    }
}
