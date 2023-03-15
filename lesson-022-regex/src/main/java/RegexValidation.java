import java.io.*;
import java.util.regex.Pattern;

public class RegexValidation {
    // +7-123-456-78-90
    // +7 123 456 78 90
//    private static final Pattern pattern = Pattern.compile("\\+\\d{1,3}[- ]\\d{3}[- ]\\d{3}[- ]\\d{2}[- ]\\d{2}");
    private static final Pattern pattern = Pattern.compile("re\\w{7}([- ])(\\w{1,3})(notehutneohu)");

    // игнорируем throws IOException
    public static void main(String[] args) throws IOException {
        var consoleReader = createConsoleReader();
        System.out.println("Input phone number:");
        String input = consoleReader.readLine();

        var matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("Phone number is correct");
            String matchedGroup = matcher.group(1);
            String matchedGroup2 = matcher.group(2);
            System.out.println("Matched group 1: " + matchedGroup);
            System.out.println("Matched group 2: " + matchedGroup2);
            System.out.println("Matched group 2: " + matcher.group(3));
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
