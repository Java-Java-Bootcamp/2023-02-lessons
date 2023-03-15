import java.io.*;
import java.util.regex.Pattern;

public class NumbersValidation {
    private static final Pattern pattern = Pattern.compile(".*");

    // игнорируем throws IOException
    public static void main(String[] args) throws IOException {
        var consoleReader = createConsoleReader();
        String input = consoleReader.readLine();

        var matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("pattern is matched");
            // some logic here
        }
    }

    // игнорируем страшную конструкцию
    private static LineNumberReader createConsoleReader() {
        return new LineNumberReader(new InputStreamReader(System.in));
    }
}
